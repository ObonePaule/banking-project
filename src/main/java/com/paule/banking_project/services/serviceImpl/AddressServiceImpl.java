package com.paule.banking_project.services.serviceImpl;

import com.paule.banking_project.dto.AddressDto;
import com.paule.banking_project.models.Address;
import com.paule.banking_project.repositories.AddressRepository;
import com.paule.banking_project.services.AddressService;
import com.paule.banking_project.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private ObjectsValidator<AddressDto> objectsValidator;

    @Override
    public Integer save(AddressDto addressDto) {
        objectsValidator.validate(addressDto);
        Address address = AddressDto.toAddress(addressDto);
        return addressRepository.save(address).getId();
    }

    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(AddressDto::fromAddress)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Integer id) {
        return addressRepository.findById(id)
                .map(AddressDto::fromAddress)
                .orElseThrow(() -> new EntityNotFoundException("No address found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }
}

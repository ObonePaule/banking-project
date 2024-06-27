package com.paule.banking_project.services.serviceImpl;

import com.paule.banking_project.dto.ContactDto;
import com.paule.banking_project.models.Contact;
import com.paule.banking_project.repositories.ContactRepository;
import com.paule.banking_project.services.ContactService;
import com.paule.banking_project.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private ObjectsValidator<ContactDto> objectsValidator;

    @Override
    public Integer save(ContactDto contactDto) {
        objectsValidator.validate(contactDto);
        Contact contact = ContactDto.toContact(contactDto);
        return contactRepository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return contactRepository.findAll()
                .stream()
                .map(ContactDto::fromContact)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Integer id) {
        return contactRepository.findById(id)
                .map(ContactDto::fromContact)
                .orElseThrow(() -> new EntityNotFoundException("No contact found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        contactRepository.deleteById(id);

    }
}

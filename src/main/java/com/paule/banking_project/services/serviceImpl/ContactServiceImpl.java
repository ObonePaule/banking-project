package com.paule.banking_project.services.serviceImpl;

import com.paule.banking_project.dto.ContactDto;
import com.paule.banking_project.services.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    @Override
    public Integer save(ContactDto dto) {
        return 0;
    }

    @Override
    public List<ContactDto> findAll() {
        return List.of();
    }

    @Override
    public ContactDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}

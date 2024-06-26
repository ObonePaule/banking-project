package com.paule.banking_project.services.serviceImpl;

import com.paule.banking_project.dto.TransactionDto;
import com.paule.banking_project.services.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public Integer save(TransactionDto dto) {
        return 0;
    }

    @Override
    public List<TransactionDto> findAll() {
        return List.of();
    }

    @Override
    public TransactionDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}

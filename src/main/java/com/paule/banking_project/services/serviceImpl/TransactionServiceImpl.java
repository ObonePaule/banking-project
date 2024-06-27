package com.paule.banking_project.services.serviceImpl;

import com.paule.banking_project.dto.AddressDto;
import com.paule.banking_project.dto.TransactionDto;
import com.paule.banking_project.models.Transaction;
import com.paule.banking_project.models.TransactionType;
import com.paule.banking_project.repositories.TransactionRepository;
import com.paule.banking_project.services.TransactionService;
import com.paule.banking_project.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private ObjectsValidator<TransactionDto> objectsValidator;

    @Override
    public Integer save(TransactionDto transactionDto) {
        objectsValidator.validate(transactionDto);
        Transaction transaction = TransactionDto.toTransaction(transactionDto);
        BigDecimal transactionMultiplier = BigDecimal.valueOf(transactionType(transaction.getType()));
        BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
        transaction.setAmount(amount);
        return transactionRepository.save(transaction).getId();
    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionDto::fromTransaction)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Integer id) {
        return transactionRepository.findById(id)
                .map(TransactionDto::fromTransaction)
                .orElseThrow(() -> new EntityNotFoundException("No transaction found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }

    private int transactionType(TransactionType type){
        return TransactionType.TRANSFERT == type ? -1 : 1;
    }
}

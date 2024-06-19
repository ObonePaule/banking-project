package com.paule.banking_project.dto;

import com.paule.banking_project.models.Transaction;
import com.paule.banking_project.models.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionDto {

    private Integer id;

    private BigDecimal amount;

    private TransactionType type;

    private String destinationIban;

    public static TransactionDto fromTransaction(Transaction transaction) {
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .destinationIban(transaction.getDestinationIban())
                .build();
    }

    public static Transaction toTransaction(TransactionDto transactionDto) {
        return Transaction.builder()
                .id(transactionDto.getId())
                .amount(transactionDto.getAmount())
                .type(transactionDto.getType())
                .destinationIban(transactionDto.getDestinationIban())
                .build();
    }
}

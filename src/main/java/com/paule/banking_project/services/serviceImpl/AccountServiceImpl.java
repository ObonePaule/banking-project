package com.paule.banking_project.services.serviceImpl;

import com.paule.banking_project.dto.AccountDto;
import com.paule.banking_project.exceptions.OperationNonPermittedException;
import com.paule.banking_project.models.Account;
import com.paule.banking_project.repositories.AccountRepository;
import com.paule.banking_project.services.AccountService;
import com.paule.banking_project.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private ObjectsValidator<AccountDto> objectsValidator;

    @Override
    public Integer save(AccountDto accountDto) {
        if(accountDto.getId() != null){
            throw  new OperationNonPermittedException(
                    "Account cannot be updated",
                    "save account",
                    "Account",
                    "Update not permitted"
            );
        }
        objectsValidator.validate(accountDto);
        Account account = AccountDto.toAccount(accountDto);
        account.setIban((generateRandomIban()));
        return accountRepository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return List.of();
    }

    @Override
    public AccountDto findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    private String generateRandomIban(){
        String iban = Iban.random(CountryCode.FR).toFormattedString();
        boolean ibanExists = accountRepository.findByIban(iban).isPresent();
        if(ibanExists){
            generateRandomIban();
        }
        return iban;
    }
}

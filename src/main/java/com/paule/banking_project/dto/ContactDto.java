package com.paule.banking_project.dto;

import com.paule.banking_project.models.Contact;
import com.paule.banking_project.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ContactDto {

    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String iban;

    private Integer userId;

    public static ContactDto fromContact(Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .userId(contact.getUser().getId())
                .build();
    }

    public static Contact toContact(ContactDto contactDto) {
        return Contact.builder()
                .id(contactDto.getId())
                .firstname(contactDto.getFirstname())
                .lastname(contactDto.getLastname())
                .email(contactDto.getEmail())
                .iban(contactDto.getIban())
                .user(User.builder()
                        .id(contactDto.getId())
                        .build())
                .build();
    }
}

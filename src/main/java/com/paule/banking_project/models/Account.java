package com.paule.banking_project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Integer id;

    private String iban;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}

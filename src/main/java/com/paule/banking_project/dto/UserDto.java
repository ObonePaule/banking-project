package com.paule.banking_project.dto;

import com.paule.banking_project.models.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;

    @NotNull
    @NotEmpty
    @NotBlank
    private String firstname;

    @NotNull
    @NotEmpty
    @NotBlank
    private String lastname;

    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto userDto) {
        return User.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}

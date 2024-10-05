package com.example.homebanking_reactive.validations;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.exceptions.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.example.homebanking_reactive.utils.MessageUtil.*;

@Service
public class ClientAppValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return ClientApplicationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClientApplicationDTO clientAppDTO = (ClientApplicationDTO) target;
        validateClientAppDTO(clientAppDTO);
    }

    public void validateClientAppDTO(ClientApplicationDTO clientAppDTO) {
        validateName(clientAppDTO.name());
        validateLastName(clientAppDTO.lastName());
        validateEmail(clientAppDTO.email());
        regexEmail(clientAppDTO.email());
        validatePassword(clientAppDTO.password());
        regexPassword(clientAppDTO.password());
    }

    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException(CLIENT_NAME_INVALID);
        }
    }

    public void validateLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            throw new ValidationException(CLIENT_LAST_NAME_INVALID);
        }
    }

    public void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new ValidationException(CLIENT_EMAIL_INVALID);
        }
    }

    public void regexEmail(String email) {
        if (!email.matches("^(?!.*\\.\\.)[A-Za-z0-9.]{1,88}@finovate\\.com$")) {
            throw new ValidationException(EMAIL_MATCH_REGEX);
        }
    }

    public void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new ValidationException(CLIENT_PASSWORD_INVALID);
        }
    }

    public void regexPassword(String password) {
        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+]).{8,}$")) {
            throw new ValidationException(PASSWORD_MATCH_REGEX);
        }
    }

}

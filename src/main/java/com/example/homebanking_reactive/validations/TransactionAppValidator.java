package com.example.homebanking_reactive.validations;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.exceptions.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.example.homebanking_reactive.utils.TransactionMessageUtil.*;

@Service
public class TransactionAppValidator implements Validator {

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean supports(Class<?> clazz) {
        return TransactionApplicationDTO.class.equals(clazz);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void validate(Object target, Errors errors) {
        TransactionApplicationDTO transactionApp = (TransactionApplicationDTO) target;
        validateTransactionAppDTO(transactionApp);
    }

    private void validateTransactionAppDTO(TransactionApplicationDTO transactionApp) {
        validateAmount(transactionApp.amount());
        validateDescription(transactionApp.description());
        regexDescription(transactionApp.description());
        validateSourceAccountNumber(transactionApp.sourceAccountNumber());
        validateDestinationAccountNumber(transactionApp.destinationAccountNumber());
        validateContentOfSourceAccountNumber(transactionApp.sourceAccountNumber());
        validateContentOfDestinationAccountNumber(transactionApp.destinationAccountNumber());
        validateDestinationNotEqualsToSourceAccountNumber(transactionApp.destinationAccountNumber(), transactionApp.sourceAccountNumber());
    }

    private void validateAmount(Double amount) {
        if (amount <= 0) {
            throw new ValidationException(AMOUNT_ERROR);
        }
    }

    private void validateDescription(String description) {
        if (description != null && description.isBlank()) {
            throw new ValidationException(DESCRIPTION_BLANK);
        }
    }

    private void regexDescription(String description) {
        if (description != null && !description.matches("^.{10,100}$")) {
            throw new ValidationException(DESCRIPTION_ERROR);
        }
    }

    private void validateSourceAccountNumber(String sourceAccountNumber) {
        if (sourceAccountNumber == null || sourceAccountNumber.isBlank()) {
            throw new ValidationException(SOURCE_ACCOUNT_EMPTY);
        }
    }

    private void validateDestinationAccountNumber(String destinationAccountNumber) {
        if (destinationAccountNumber == null || destinationAccountNumber.isBlank()) {
            throw new ValidationException(DESTINATION_ACCOUNT_EMPTY);
        }
    }

    private void validateContentOfSourceAccountNumber(String sourceAccountNumber) {
        if (!sourceAccountNumber.matches("^\\d+$")) {
            throw new ValidationException(SOURCE_ACCOUNT_ERROR);
        }
    }

    private void validateContentOfDestinationAccountNumber(String destinationAccountNumber) {
        if (!destinationAccountNumber.matches("^\\d+$")) {
            throw new ValidationException(DESTINATION_ACCOUNT_ERROR);
        }
    }

    private void validateDestinationNotEqualsToSourceAccountNumber(String destinationAccountNumber, String sourceAccountNumber) {
        if (sourceAccountNumber.equals(destinationAccountNumber)) {
            throw new ValidationException(ACCOUNT_NUMBERS_EQUALS);
        }
    }
}

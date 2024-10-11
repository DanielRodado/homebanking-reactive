package com.example.homebanking_reactive.utils;

public final class TransactionMessageUtil {

    public static final String AMOUNT_ERROR = "Amount must be greater than 0";
    public static final String DESCRIPTION_BLANK = "Description cannot be blank";
    public static final String DESCRIPTION_ERROR = "Description must be between 10 and 100 characters";

    public static final String SOURCE_ACCOUNT_EMPTY = "Source account number cannot be empty";
    public static final String DESTINATION_ACCOUNT_EMPTY = "Destination account number cannot be empty";

    public static final String SOURCE_ACCOUNT_ERROR = "Source account number invalid, must be numeric";
    public static final String DESTINATION_ACCOUNT_ERROR = "Destination account number invalid, must be numeric";

    public static final String ACCOUNT_NUMBERS_EQUALS = "Source account number cannot be equal to destination account number";

    public static String transactionCompleted(Double amount, String destinationAccountNumber) {
        return "A transaction of $" + amount +" to account V-" + destinationAccountNumber + " was successfully completed.";
    }

}

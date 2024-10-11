package com.example.homebanking_reactive.utils;

public class MessageUtil {

    public static final String CLIENT_NOT_FOUND = "Client not found";
    public static final String ACCOUNT_NOT_FOUND = "Account not found";
    public static final String ACCOUNT_SOURCE_NOT_FOUND = "The account from which the funds are to be withdrawn was not found";
    public static final String ACCOUNT_DESTINATION_NOT_FOUND = "The destination account for the transaction was not found";

    public static final String CLIENT_EMAIL_EXIST = "You can't use this email address, try a different one";

    public static final String CLIENT_NAME_INVALID = "Name invalid, cannot be empty";
    public static final String CLIENT_LAST_NAME_INVALID = "Last name invalid, cannot be empty";
    public static final String CLIENT_EMAIL_INVALID = "Email invalid, cannot be empty";
    public static final String CLIENT_PASSWORD_INVALID = "Password invalid, cannot be empty";

    public static final String ACCOUNT_TYPE_INVALID = "Account type invalid";
    public static final String ACCOUNT_TYPE_EMPTY = "Account type cannot be empty";
    public static final String ACCOUNT_NUMBER_ERROR = "Error generating account number, try again";
    public static final String INSUFFICIENT_ACCOUNT_BALANCE = "The account balance is insufficient to carry out the transaction";

    public static final String EMAIL_MATCH_REGEX = "The email must be a maximum of 100 characters, including the " +
            "domain @finovate.com. Before the @, upper and lower case letters, numbers and periods (not consecutive) " +
            "are allowed, but the domain must always be in lower case.";
    public static final String PASSWORD_MATCH_REGEX = "Your password must be at least 8 characters long, include one uppercase " +
            "letter, one lowercase letter, one number and one of these symbols: !@#$%^&*()_+";

    public static final String ACCOUNT_CREATED = "Account created!";

}

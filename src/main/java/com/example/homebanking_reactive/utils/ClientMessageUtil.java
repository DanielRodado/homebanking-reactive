package com.example.homebanking_reactive.utils;

public final class ClientMessageUtil {

    public static final String CLIENT_NOT_FOUND = "Client not found";

    public static final String CLIENT_EMAIL_EXIST = "You can't use this email address, try a different one";

    public static final String CLIENT_NAME_INVALID = "Name invalid, cannot be empty";
    public static final String CLIENT_LAST_NAME_INVALID = "Last name invalid, cannot be empty";
    public static final String CLIENT_EMAIL_INVALID = "Email invalid, cannot be empty";
    public static final String CLIENT_PASSWORD_INVALID = "Password invalid, cannot be empty";

    public static final String EMAIL_MATCH_REGEX = "The email must be a maximum of 100 characters, including the " +
            "domain @finovate.com. Before the @, upper and lower case letters, numbers and periods (not consecutive) " +
            "are allowed, but the domain must always be in lower case";
    public static final String PASSWORD_MATCH_REGEX = "Your password must be at least 8 characters long, include one uppercase " +
            "letter, one lowercase letter, one number and one of these symbols: !@#$%^&*()_+";

}

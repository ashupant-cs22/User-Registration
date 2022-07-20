package com.bridgelabz;

import java.util.regex.Pattern;

@FunctionalInterface
interface UserDetailsValidationFI {
    boolean validate(String string) throws UserRegistrationException;
}

public class UserRegistration {
    // Using lambda function to check firstname Valid or Invalid
    UserDetailsValidationFI validateFirstName = firstName -> {
        if (Pattern.matches("[A-Z][a-z A-Z]{2,}", firstName))
            return true;
        else
            throw new UserRegistrationException("Invalid First Name");
    };

    // Using lambda function to check lastName Valid or Invalid
    UserDetailsValidationFI validateLastname = lastName -> {
        if (Pattern.matches("[A-Z][a-z A-Z]{2,}", lastName))
            return true;
        else
            throw new UserRegistrationException("Invalid Last Name");
    };

    // Using lambda function to check email Valid or Invalid
    UserDetailsValidationFI validateEmail = email -> {
        if (Pattern.matches("[\\w+-]+(?:\\.[\\w+-]+)*[@][\\w]{1,}([.]{1}[a-z]{2,}){1,2}", email))
            return true;
        else
            throw new UserRegistrationException("Invalid Email");
    };

    // Using lambda function to check mobile number Valid or Invalid
    UserDetailsValidationFI validateMobileNumber = mobileNumber -> {
        if (Pattern.matches("[+]91 [6-9]\\d{9}", mobileNumber))
            return true;
        else
            throw new UserRegistrationException("Invalid Mobile Number");
    };
    // Using lambda function to check the password Valid or Invalid
    UserDetailsValidationFI validatePassword = password -> {
        if (Pattern.matches("(?=.*[A-Z])(?=.*\\d)(?=.*[$&+,:;=?@#|'<>.-^*()%!])[a-z A-Z \\d $&+,:;=?@#|'<>.-^*()%!]{8,}", password))
            return true;
        else
            throw new UserRegistrationException("Invalid Password");
    };
}

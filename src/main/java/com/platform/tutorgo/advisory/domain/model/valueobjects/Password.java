package com.platform.tutorgo.advisory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public record Password(String password) {
    // Contraseña de 8-16 caracteres con al menos un dígito, al menos uno
    // letra minúscula, al menos una letra mayúscula, al menos una
    // caracter especial sin espacios en blanco

    private static final String PASSWORD_REGEX =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,16}$";
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(PASSWORD_REGEX);

    public Password(){
        this(null);
    }

    public Password{
        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Password cannot be null or blank");

        /*if (password.length()<10)
            throw new IllegalArgumentException("Password cannot be less than 10 characters");
        if (!PASSWORD_PATTERN.matcher(password).matches())
            throw new IllegalArgumentException("Password isn't valid");*/
    }

}

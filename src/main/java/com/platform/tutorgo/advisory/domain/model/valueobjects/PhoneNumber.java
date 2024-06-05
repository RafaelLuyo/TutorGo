package com.platform.tutorgo.advisory.domain.model.valueobjects;


public record PhoneNumber(String phonenumber) {
    public PhoneNumber {
        if (phonenumber == null || phonenumber.length() != 9 || !phonenumber.matches("\\d+")) {
            throw new IllegalArgumentException("El número de teléfono debe tener exactamente 9 dígitos.");
        }
    }
}

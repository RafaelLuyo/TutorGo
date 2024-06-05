package com.platform.tutorgo.advisory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Subscription(String subscription) {

    public Subscription() {
        this(null);
    }

    public Subscription {
        if (subscription == null || subscription.isBlank()) {
            throw new IllegalArgumentException("Subscription cannot be null or blank");
        }
    }
}

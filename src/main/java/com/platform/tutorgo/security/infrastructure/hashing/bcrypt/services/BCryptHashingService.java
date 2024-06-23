package com.platform.tutorgo.security.infrastructure.hashing.bcrypt.services;

import com.platform.tutorgo.security.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}

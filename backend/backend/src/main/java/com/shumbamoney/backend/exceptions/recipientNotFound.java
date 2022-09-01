package com.shumbamoney.backend.exceptions;

public class recipientNotFound extends RuntimeException {
        public recipientNotFound(String message) {
            super(message);
        }
    }

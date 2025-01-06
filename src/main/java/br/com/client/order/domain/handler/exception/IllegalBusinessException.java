package br.com.client.order.domain.handler.exception;

public class IllegalBusinessException extends RuntimeException {
    public IllegalBusinessException(String message) {
        super(message);
    }
}
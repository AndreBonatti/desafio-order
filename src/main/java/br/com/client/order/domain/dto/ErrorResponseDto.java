package br.com.client.order.domain.dto;

public class ErrorResponseDto {
    private String message;
    private Object details;

    public ErrorResponseDto(String message, Object details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public Object getDetails() {
        return details;
    }
}
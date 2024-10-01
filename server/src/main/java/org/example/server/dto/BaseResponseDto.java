package org.example.server.dto;

public class BaseResponseDto {

    private String status;
    private Object data; // Peut être un DTO spécifique ou un objet générique
    private String message; // Un message comme "success", "failed", etc.

    public BaseResponseDto(String status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    // Getters et Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}

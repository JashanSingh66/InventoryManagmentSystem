package com.track.inventory.exception;

public class ErrorResponse {
    private final int status;
    private final String error;

    public ErrorResponse(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public int getStatus() { return status; }
    public String getError() { return error; }

}

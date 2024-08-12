package com.emp.EmployeeMgmt.exception;

public class DuplicateEntryException extends RuntimeException {
    private String fieldName;

    public DuplicateEntryException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}

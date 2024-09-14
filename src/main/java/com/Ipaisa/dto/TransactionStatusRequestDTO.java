package com.Ipaisa.dto;



public class TransactionStatusRequestDTO {

    private String transactionDate;
    private String externalRef;

    // Constructors
    public TransactionStatusRequestDTO() {}

    public TransactionStatusRequestDTO(String transactionDate, String externalRef) {
        this.transactionDate = transactionDate;
        this.externalRef = externalRef;
    }

    // Getters and Setters
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getExternalRef() {
        return externalRef;
    }

    public void setExternalRef(String externalRef) {
        this.externalRef = externalRef;
    }

    // ToString method
    @Override
    public String toString() {
        return "TransactionStatusRequestDTO{" +
                "transactionDate='" + transactionDate + '\'' +
                ", externalRef='" + externalRef + '\'' +
                '}';
    }
}

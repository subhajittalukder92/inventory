package com.example.testproject.dto;


public class ClientDto {
    private String clientName;
    private String contactNo;
    public ClientDto() {

    }
    public ClientDto(String clientName, String contactNo) {
        this.clientName = clientName;
        this.contactNo = contactNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}

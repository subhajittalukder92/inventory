package com.example.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clientName;
    private String contact;

    public Client() {
    }

    public Client(int id, String clientName, String contact) {
        this.id = id;
        this.clientName = clientName;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}

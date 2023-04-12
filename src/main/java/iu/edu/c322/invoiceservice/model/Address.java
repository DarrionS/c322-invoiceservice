package iu.edu.c322.invoiceservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
class Address {
    @NotEmpty(message = "state not found.")
    private String state;

    @NotEmpty(message = "city not found.")
    private String city;

    private int postalCode;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

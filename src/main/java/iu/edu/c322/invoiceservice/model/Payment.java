package iu.edu.c322.invoiceservice.model;

import jakarta.persistence.*;

@Entity
class Payment {
    private String method;
    private String number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address billingAddress;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getMethod() {
        return method;
    }

    public String getNumber() {
        return number;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

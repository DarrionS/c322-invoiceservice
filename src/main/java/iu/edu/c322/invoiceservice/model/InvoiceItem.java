package iu.edu.c322.invoiceservice.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String status;

    @OneToMany
    private List<OrderItem> items;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private Date date;

    public Date getOn() {
        return date;
    }

    public void setOn(Date date) {
        this.date = date;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

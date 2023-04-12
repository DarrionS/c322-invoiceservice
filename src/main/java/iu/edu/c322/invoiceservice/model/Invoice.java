package iu.edu.c322.invoiceservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String orderPlaced;

    private float total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToMany
    private List<InvoiceItem> invoiceItems;

    public void setTotal(float total) {
        this.total = total;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public void setInvoiceItems(List<InvoiceItem> items) {
        this.invoiceItems = items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public float getTotal() {
        return this.total;
    }

    public String getOrderPlaced() {
        return this.orderPlaced;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return this.invoiceItems;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public int getId() {
        return this.id;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Invoice)) {
            return false;
        }
        Invoice invoice = (Invoice) o;
        return id == invoice.id && Objects.equals(invoiceItems, invoice.invoiceItems) && Objects.equals(total, invoice.total) && Objects.equals(payment, invoice.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceItems, total, payment);
    }
}



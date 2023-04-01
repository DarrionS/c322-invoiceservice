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

    private double total;

    private Payment payment;

    private InvoiceItem invoiceItems = new InvoiceItem();

    public void setTotal(double total) {
        this.total = total;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public void setInvoiceItems(InvoiceItem items) {
        this.invoiceItems = items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setStatus() {
        this.invoiceItems.setStatus("shipping now");
    }

    public double getTotal() {
        return this.total;
    }

    public String getOrderPlaced() {
        return this.orderPlaced;
    }

    public InvoiceItem getInvoiceItems() {
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

@Embeddable
class InvoiceItem {

    private String status;

    @OneToMany
    List<Item> items = new ArrayList<>();
    private String on;
    private ShippingAddress address;
    @Id
    private int id;

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public void setAddress(ShippingAddress address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public String getOn() {
        return on;
    }

    public ShippingAddress getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

@Embeddable
class ShippingAddress {
    @NotEmpty(message = "state not found.")
    @Column(name = "state", insertable = false, updatable = false)
    private String state;

    @NotEmpty(message = "city not found.")
    @Column(name = "city", insertable = false, updatable = false)
    private String city;

    @Column(name = "postal", insertable = false, updatable = false)
    private int postalCode;
    @Id
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


@Entity
class Item {
    @NotEmpty(message = "item name not found.")
    private String item;
    private int price;
    @Id
    private int id;

    public void setItem(String item) {
        this.item = item;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
@Embeddable
class Payment {
    private String method;
    private String number;

    private ShippingAddress billingAddress;
    @Id
    private int id;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBillingAddress(ShippingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getMethod() {
        return method;
    }

    public String getNumber() {
        return number;
    }

    public ShippingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

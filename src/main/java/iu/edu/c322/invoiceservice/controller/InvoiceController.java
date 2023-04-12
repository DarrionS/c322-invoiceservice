package iu.edu.c322.invoiceservice.controller;

import iu.edu.c322.invoiceservice.model.Invoice;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import iu.edu.c322.invoiceservice.model.Order;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final WebClient orderService;


    public InvoiceController(WebClient.Builder webClientBuilder) {
        orderService = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    @GetMapping("/{orderId}")
    public Invoice findByOrderId(@PathVariable int orderId) {
        Order order =  orderService.get().uri("/orders/order/{orderId}", orderId)
                .retrieve()
                .bodyToMono(Order.class).block();
        Invoice invoice = new Invoice();
        invoice.setTotal(order.getTotal());
        invoice.setPayment(order.getPayment());
        return invoice;
    }
}

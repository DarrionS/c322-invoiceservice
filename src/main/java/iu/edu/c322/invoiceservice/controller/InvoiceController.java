package iu.edu.c322.invoiceservice.controller;

import iu.edu.c322.invoiceservice.model.Invoice;
import iu.edu.c322.invoiceservice.repository.InvoiceRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private InvoiceRepository repository;


    public InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Invoice> findAll() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Invoice invoice){
        Invoice newInvoice = repository.save(invoice);
        return newInvoice.getId();
    }

    // PUT localhost:808/invoices/2
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Invoice invoice, @PathVariable int id) {
        invoice.setId(id);
        invoice.setStatus();
        repository.save(invoice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Invoice invoice = new Invoice();
        invoice.setId(id);
        repository.delete(invoice);
    }
}

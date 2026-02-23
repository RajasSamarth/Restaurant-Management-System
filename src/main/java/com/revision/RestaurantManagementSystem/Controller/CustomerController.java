package com.revision.RestaurantManagementSystem.Controller;


import com.revision.RestaurantManagementSystem.Entity.Customer;
import com.revision.RestaurantManagementSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //add customer
    @PostMapping("/add-customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
    }

    //get all customer
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> list = customerService.getAllCustomer();
        return ResponseEntity.ok(list);
    }

    //find by Id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable int id){
        Optional<Customer> list = customerService.getCustomerById(id);
        return ResponseEntity.ok(list);
    }


    //delete customer by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }

    //update customer
    @PatchMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer)
    {
        return ResponseEntity.ok(customerService.updateCustomerById(id,customer));
    }


}

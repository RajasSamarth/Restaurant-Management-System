package com.revision.RestaurantManagementSystem.Service;


import com.revision.RestaurantManagementSystem.Entity.Customer;
import com.revision.RestaurantManagementSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    //get all customers
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    //get customer by id
    public Optional<Customer> getCustomerById(int id){
        Optional<Customer> list  = customerRepository.findById(id);
        return list;
    }

    //add customer
    public Customer addCustomer(Customer customer){

        return customerRepository.save(customer);
    }
    //delete customer
    public void deleteCustomerById(int id){
        customerRepository.deleteById(id);

    }


    //update customer
    public Customer updateCustomerById(int id, Customer customer){

        Optional<Customer> customer1 = customerRepository.findById(id);

        if(customer1.isPresent()){
            Customer newCustomer = customer1.get();

            if(customer.getName()!=null){
                newCustomer.setName(customer.getName());
            }
            if(customer.getEmail()!=null){
                newCustomer.setEmail(customer.getEmail());
            }
            if(customer.getPhone()!=null){
                newCustomer.setPhone(customer.getPhone());
            }

            return customerRepository.save(newCustomer);
        }


        return null;

    }
}

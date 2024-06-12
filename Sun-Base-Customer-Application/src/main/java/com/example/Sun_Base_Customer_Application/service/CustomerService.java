package com.example.Sun_Base_Customer_Application.service;


import com.example.Sun_Base_Customer_Application.exception.ResourceNotFoundException;
import com.example.Sun_Base_Customer_Application.exception.UnauthorizedException;
import com.example.Sun_Base_Customer_Application.model.Customer;
import com.example.Sun_Base_Customer_Application.model.User;
import com.example.Sun_Base_Customer_Application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // create customer
    public Customer createCustomer(Customer customer, User user){
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    //update customer
    public Customer updateCustomer(Long id, Customer customerDetails, User user){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        if (!customer.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("You are not authorized to update this customer");
        }
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setStreet(customerDetails.getStreet());
        customer.setAddress(customerDetails.getAddress());
        customer.setCity(customerDetails.getCity());
        customer.setState(customerDetails.getState());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());
        return customerRepository.save(customer);
    }

    //get all customers
    public Page<Customer> getAllCustomers(User user, int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return customerRepository.findByUser(user, pageable);
    }

    // get customer by id
    public Customer getCustomerById(Long id, User user){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        if(!customer.getUser().getId().equals(user.getId())){
            throw new UnauthorizedException("You are not authorized to view this customer");

        }
        return customer;
    }

    // deleteCustomer
    public void deleteCustomer(Long id, User user){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        if(!customer.getUser().getId().equals(user.getId())){
            throw new UnauthorizedException("You are not authorized to delete this customer");
        }
        customerRepository.delete(customer);
    }
}
/*
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null;
    }

    public List<Customer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable).getContent();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public boolean deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}*/

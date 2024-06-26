package com.example.Sun_Base_Customer_Application.controller;

import com.example.Sun_Base_Customer_Application.exception.ResourceNotFoundException;
import com.example.Sun_Base_Customer_Application.model.Customer;
import com.example.Sun_Base_Customer_Application.model.User;
import com.example.Sun_Base_Customer_Application.payload.LoginRequest;
import com.example.Sun_Base_Customer_Application.repository.UserRepository;
import com.example.Sun_Base_Customer_Application.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserRepository userRepository;

    // create customer
    // http://localhost:8080/api/customers
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer , Authentication authentication){
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return customerService.createCustomer(customer, user);
    }

    // update customer
    // http://localhost:8080/api/customers/id
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails, Authentication authentication){
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return customerService.updateCustomer(id, customerDetails, user);
    }

    // get all customer
    // http://localhost:8080/api/customers
    @GetMapping
    public Page<Customer> getAllCustomers(Authentication authentication,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "id") String sortBy,
                                          @RequestParam(required = false) String searchBy,
                                          @RequestParam(required = false) String searchValue) {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return customerService.getAllCustomers(user, page, size, sortBy, searchBy, searchValue);
    }

    // get customer by id
    // http://localhost:8080/api/customers/id
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id, Authentication authentication){
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return customerService.getCustomerById(id, user);
    }

    // delete customer by id
    // http://localhost:8080/api/customers/id
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id, Authentication authentication){
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->new ResourceNotFoundException("User not found"));
        customerService.deleteCustomer(id, user);
        return "Customer deleted successfully";
    }

    // sync customers from remote API
    @PostMapping("/sync")
    public ResponseEntity<String> syncCustomers(@RequestBody LoginRequest loginRequest, Authentication authentication) throws JsonProcessingException, JsonProcessingException {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        customerService.syncCustomers(loginRequest, user);
        return ResponseEntity.ok("Customers synced successfully");
    }
}

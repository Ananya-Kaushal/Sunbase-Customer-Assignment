package com.example.Sun_Base_Customer_Application.repository;

import com.example.Sun_Base_Customer_Application.model.Customer;
import com.example.Sun_Base_Customer_Application.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    Page<Customer> findByUser(User user, Pageable pageable);
    Page<Customer> findByUserAndFirstNameContaining(User user, String firstName, Pageable pageable);
    Page<Customer> findByUserAndCityContaining(User user, String city, Pageable pageable);
    Page<Customer> findByUserAndEmailContaining(User user, String email, Pageable pageable);
    Page<Customer> findByUserAndPhoneContaining(User user, String phone, Pageable pageable);
}

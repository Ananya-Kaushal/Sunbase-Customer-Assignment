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

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /*// Custom query to find customers by city
    List<Customer> findByCity(String city);

    // Custom query using JPQL
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(@Param("email") String email);

    // Custom query using native SQL
    @Query(value = "SELECT * FROM customers WHERE phone = :phone", nativeQuery = true)
    Customer findByPhone(@Param("phone") String phone);*/

    Page<Customer> findByUser(User user, Pageable pageable);
}

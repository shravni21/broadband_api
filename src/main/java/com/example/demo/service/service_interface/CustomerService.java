package com.example.demo.service.service_interface;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Integer id);
    void addBroadbandtoCustomer(int cust_id, int broadbandId);
}

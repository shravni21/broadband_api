package com.example.demo.service.service_Impl;

import com.example.demo.dao.BroadbandRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.Broadband;
import com.example.demo.entity.Customer;
import com.example.demo.service.service_interface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    private BroadbandRepository broadbandRepository;

    @Autowired
    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void addBroadbandtoCustomer(int cust_id, int broadbandId) {
        Customer customer = customerRepository.findById(cust_id).orElse(null);
        Broadband broadband = broadbandRepository.findById(broadbandId).orElse(null);
        customer.setBroadband(broadband);

        customerRepository.save(customer);
    }
}
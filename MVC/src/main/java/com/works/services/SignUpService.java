package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SignUpService {

    final CustomerRepository customerRepository;

    public boolean signup(Customer customer) {
        System.out.println(customer);
        List<String> cities = new ArrayList<>();
        cities.add("1");
        cities.add("2");
        cities.add("3");
        if (cities.contains(customer.getCity())) {
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

}

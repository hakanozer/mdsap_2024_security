package com.works.services;

import com.works.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignUpService {

    public boolean signup(Customer customer) {
        System.out.println(customer);
        List<String> cities = new ArrayList<>();
        cities.add("1");
        cities.add("2");
        cities.add("3");
        if (cities.contains(customer.getCity())) {
            return true;
        }
        return false;
    }

}

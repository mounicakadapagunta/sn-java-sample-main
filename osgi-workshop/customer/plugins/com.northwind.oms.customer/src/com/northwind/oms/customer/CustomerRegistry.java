package com.northwind.oms.customer;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory directory of {@link Customer} records keyed by customer id.
 */
public class CustomerRegistry {

    private final Map<String, Customer> customers = new ConcurrentHashMap<>();

    public void register(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("customer is required");
        }
        customers.put(customer.getCustomerId(), customer);
    }

    public Optional<Customer> find(String customerId) {
        if (customerId == null || customerId.isBlank()) {
            return Optional.empty();
        }
        return Optional.ofNullable(customers.get(customerId));
    }

    public boolean exists(String customerId) {
        if (customerId == null || customerId.isBlank()) {
            return false;
        }
        return customers.containsKey(customerId);
    }

    public int size() {
        return customers.size();
    }
}

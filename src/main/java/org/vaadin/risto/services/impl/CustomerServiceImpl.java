package org.vaadin.risto.services.impl;

import org.vaadin.risto.services.CustomerService;

import java.util.Arrays;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public String reverseString(String param) {
        char[] chars = param.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

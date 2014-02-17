package org.vaadin.risto.ui.presenters.impl;

import com.vaadin.cdi.UIScoped;
import org.vaadin.risto.services.CustomerService;
import org.vaadin.risto.ui.presenters.CustomerPresenter;
import org.vaadin.risto.ui.views.CustomerView;

import javax.inject.Inject;

@UIScoped
public class CustomerPresenterImpl  implements CustomerPresenter {

    @Inject
    CustomerService service;

    private CustomerView customerView;

    @Override
    public void fieldValueChanged(String input) {
        String reversed = service.reverseString(input);
        customerView.showString(reversed);
    }

    @Override
    public void setView(CustomerView customerView) {
        this.customerView = customerView;
    }

}

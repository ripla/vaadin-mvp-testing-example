package org.vaadin.risto.ui.views.impl;

import org.vaadin.risto.ui.presenters.CustomerPresenter;
import org.vaadin.risto.ui.views.CustomerView;
import com.vaadin.cdi.CDIView;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@CDIView
public class CustomerViewImpl implements CustomerView {

    @Inject
    CustomerPresenter presenter;

    @PostConstruct
    public void init() {
        presenter.setView(this);
    }

    @Override
    public void showString(String param) {
        throw new UnsupportedOperationException();
    }
}

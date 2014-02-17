package org.vaadin.risto.ui.presenters;

import org.vaadin.risto.ui.views.CustomerView;

public interface CustomerPresenter {
    void fieldValueChanged(String input);

    void setView(CustomerView customerView);
}

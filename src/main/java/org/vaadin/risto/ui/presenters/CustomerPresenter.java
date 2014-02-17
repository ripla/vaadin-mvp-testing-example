package org.vaadin.risto.ui.presenters;

import org.vaadin.risto.ui.views.CustomerView;

/**
 * Presenter interface. The presenter should contain all the UI-logic. It should not have any com.vaadin dependencies.
 */
public interface CustomerPresenter {
    void fieldValueChanged(String input);

    void setView(CustomerView customerView);
}

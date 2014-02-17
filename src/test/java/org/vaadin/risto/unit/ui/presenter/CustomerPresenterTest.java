package org.vaadin.risto.unit.ui.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.vaadin.risto.services.CustomerService;
import org.vaadin.risto.ui.presenters.CustomerPresenter;
import org.vaadin.risto.ui.presenters.impl.CustomerPresenterImpl;
import org.vaadin.risto.ui.views.CustomerView;

/**
 * This is an unit test that isolates the presenter.
 */
public class CustomerPresenterTest {

    @InjectMocks
    protected CustomerPresenter presenter;

    @Mock
    CustomerView mockView;

    @Mock
    CustomerService mockService;

    @Before
    public void setUp() throws Exception {
        presenter = new CustomerPresenterImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void presenterMethod_parameterBar_callsService() throws Exception {
        presenter.fieldValueChanged("aBr");
        Mockito.verify(mockService).reverseString("aBr");
    }

    @Test
    public void presenterMethod_parameterBar_callsViewWithServiceResult() throws Exception {
        Mockito.when(mockService.reverseString("aBr")).thenReturn("Bar");
        presenter.fieldValueChanged("aBr");
        Mockito.verify(mockView).showString("Bar");
    }
}

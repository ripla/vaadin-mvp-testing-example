package org.vaadin.risto.integration.ui.presenter;

import com.vaadin.cdi.internal.BeanStoreContainer;
import com.vaadin.cdi.internal.UIBean;
import com.vaadin.ui.UI;
import com.vaadin.util.CurrentInstance;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.vaadin.risto.services.CustomerService;
import org.vaadin.risto.ui.presenters.CustomerPresenter;
import org.vaadin.risto.ui.views.CustomerView;

import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;

/**
 * This is an integration test that has the whole stack available. Calls are delegated to the backend by the presenter.
 */
@RunWith(Arquillian.class)
@RunAsClient
public class CustomerPresenterIntegrationTest {

    @Inject
    @InjectMocks
    protected CustomerPresenter presenter;

    @Mock
    CustomerView mockView;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeClass
    public static void preSetup() {
        Bean<UI> mockBean = Mockito.mock(Bean.class);
        UIBean uiBean = new UIBean(mockBean, 123);
        CurrentInstance.set(UIBean.class, uiBean);
    }

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
                                          .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        webArchive = webArchive.addPackages(true, CustomerPresenter.class.getPackage())
                               .addPackages(true, CustomerService.class.getPackage())
                               .addClass(BeanStoreContainer.class);

        return webArchive;
    }

    @Test
    public void presenterMethod_parameterBar_callsViewWithOrdered() throws Exception {
        presenter.fieldValueChanged("aBr");
        Mockito.verify(mockView).showString("Bar");
    }
}

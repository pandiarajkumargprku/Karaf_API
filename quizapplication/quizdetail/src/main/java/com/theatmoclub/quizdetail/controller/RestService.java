package com.theatmoclub.quizdetail.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class RestService {

    private Server server;

    @Reference
    private Api api;

    @Activate
    public void activate() {
        try {
            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
            bean.setAddress("/quiz");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(api);

            server = bean.create();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    @Deactivate
    public void deactivate() {
        if (server != null) {
            server.destroy();
        }
    }
}

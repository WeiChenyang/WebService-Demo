package com.example.clientdemo.client;

import client.WebServiceImpl;
import client.WebServiceImplService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Run {

    private static Log log = LogFactory.getLog(Run.class);

    public static void main(String[] args) {
        WebServiceImpl service = new WebServiceImplService().getWebServiceImplPort();
        String str = service.hiWebService("Client:Hi webService!");
        log.info(str);
    }
}

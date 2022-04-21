package com.example.demo.webService.impl;

import com.example.demo.webService.inter.WebServiceInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService
@Service
public class WebServiceImpl implements WebServiceInterface{

    private Log log = LogFactory.getLog(WebServiceInterface.class);

    @Override
    public String hiWebService(String str) {
        String msg = "WebServiceImpl获取Str>>"+str;
        log.info(msg);
        return msg;
    }
}

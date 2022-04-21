package com.example.demo.webService.inter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface WebServiceInterface {

    @WebMethod
    String hiWebService(@WebParam(name="HiWebService") String str);

}

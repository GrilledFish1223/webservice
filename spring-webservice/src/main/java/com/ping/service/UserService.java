package com.ping.service;

import com.ping.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UserService {
    @WebMethod
    String getName(@WebParam(name = "useId") Long userId);

    @WebMethod
    User getUser(Long userId);
}

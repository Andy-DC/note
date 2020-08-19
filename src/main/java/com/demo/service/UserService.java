package com.demo.service;

import java.io.IOException;

public interface UserService {

    String sendSMS(String phoneNumber, String content) throws IOException;
}

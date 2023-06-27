package com.example.Employeesecurity.Jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employeesecurity.Jwt.entity.AuthRequest;
import com.example.Employeesecurity.Jwt.service.Userservice;
import com.example.Employeesecurity.Jwt.util.JwtUtil;

@RestController
public class UserController {
    @Autowired
    private Userservice service;
    @Autowired
    private JwtUtil jwtutil;
     @Autowired
       private  AuthenticationManager authenticationManager;
    @GetMapping("/welcome")
    public String welcome() {
        return "HI WELCOME TO UST";
        
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authrequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authrequest.getUsername(),authrequest.getPassword()));
        }catch (Exception e) {
            throw new Exception("invaild username/password");
        }
        return jwtutil.generateToken(authrequest.getUsername());
        
    }
    
    
}
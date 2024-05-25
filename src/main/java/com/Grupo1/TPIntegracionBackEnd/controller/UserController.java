package com.Grupo1.TPIntegracionBackEnd.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Grupo1.TPIntegracionBackEnd.model.*;

@RestController
public class UserController {
 // Por ahora se devuelve un objeto JSON con un mensaje	
	   @PostMapping("/api/user")
	    public Map<String, String> getUserDetails(@RequestBody UserCredentials credentials) {
	        String name = credentials.getName();
	        String password = credentials.getPassword();
	        
	     
	       
	        
	        Map<String, String> userDetails = new HashMap<>();
	        userDetails.put("message", "User details for " + name);
	        return userDetails;
	    }

//	   Devuelve el saludo al usuario de manera de string
	   @GetMapping("/api/user")
	   public String getUser() {
		
	      
	        
        return "User details";
    }
}

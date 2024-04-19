package com.misael.workorder.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ValidateCustomerRegistrationService {

    @Autowired
    private RestTemplate restTemplate;

    public Boolean validate(String clientName){
        Boolean validated = false;
        ResponseEntity<Map> externalValidateCustomerApi = restTemplate
        .postForEntity("https://run.mocky.io/v3/2d64a293-89ee-42c5-bf8f-0678a71b29e2", clientName, Map.class);

        if(externalValidateCustomerApi.getStatusCode() == HttpStatus.OK){
            validated = true;
        }

        return validated;

    }
}

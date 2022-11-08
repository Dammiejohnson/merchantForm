package com.catalyst.qIForm.controllers;

import com.catalyst.qIForm.dtos.requests.MerchantRequest;
import com.catalyst.qIForm.exceptions.ClientIntegrationFormException;
import com.catalyst.qIForm.services.ClientIntegrationFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/merchant")
public class ClientIntegrationFormController {
    private ClientIntegrationFormService clientIntegrationFormService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MerchantRequest request) {
        try {
            return new ResponseEntity<>(clientIntegrationFormService.register(request), HttpStatus.CREATED);
        } catch (ClientIntegrationFormException error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

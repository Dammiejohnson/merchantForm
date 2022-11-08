package com.catalyst.qIForm.services;

import com.catalyst.qIForm.dtos.requests.MerchantRequest;
import com.catalyst.qIForm.dtos.responses.MerchantResponse;
import org.springframework.stereotype.Service;

@Service
public interface ClientIntegrationFormService {
    MerchantResponse register(MerchantRequest request);
}

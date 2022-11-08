package com.catalyst.qIForm.services;

import com.catalyst.qIForm.dtos.requests.MerchantRequest;
import com.catalyst.qIForm.dtos.responses.MerchantResponse;
import com.catalyst.qIForm.models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientIntegrationFormServiceImplTest {

    @Autowired
    ClientIntegrationFormService clientIntegrationFormService;
    MerchantRequest request;

    @BeforeEach
    void setUp() {
        request = MerchantRequest.builder()
                .companyInformation(new CompanyInformation(1L, "78095", "DamiSwitch", "Ikeja", "www.damiInt.com",
                        new RequiredService(1L, true, false, true, false)))
                .contactInformation(new ContactInformation(1L, new PrimaryContactInformation
                                (1L, new ContactPerson(1L, "Damilola", "CEO", "09123415671", "0912346543", "dami456@gmail.com")),
                        new SecondaryContactInformation
                                (1L, new ContactPerson(1L, "Damilola", "CEO", "09123415671", "0912346543", "dami456@gmail.com"))))
                .extendedInformation(new ExtendedInformation(1L, "Nigeria", "Payment service", new InitiationChannel(1L, false, true, true, true), "file"))
               .settlementAccountDetails(new SettlementAccountDetails(1L, "Damilola", "098765", "01234564", new PayFormat(1L, true, false), "09876545433"))
                .systemAccess(new SystemAccess(1L, "DAMI", "manager", "sanni@gmail.com", "09087654321"))
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
        MerchantResponse merchantResponse = clientIntegrationFormService.register(request);
        assertEquals(merchantResponse.getMessage(), "DamiSwitch registered successfully" );
    }
}
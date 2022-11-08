package com.catalyst.qIForm.services;

import com.catalyst.qIForm.dtos.requests.MerchantRequest;
import com.catalyst.qIForm.dtos.responses.MerchantResponse;
import com.catalyst.qIForm.exceptions.ClientIntegrationFormException;
import com.catalyst.qIForm.models.ClientIntegrationForm;
import com.catalyst.qIForm.repositories.ClientIntegrationFormRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ClientIntegrationFormServiceImpl implements  ClientIntegrationFormService{

    private  ModelMapper modelMapper;
    private ClientIntegrationFormRepo repo;

    @Autowired
    public ClientIntegrationFormServiceImpl(ClientIntegrationFormRepo repo) {
        this.repo = repo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MerchantResponse register(MerchantRequest request) {
        Optional<ClientIntegrationForm> companyId = repo.findById(request.getCompanyInformation().getId());
        if(companyId.isPresent()) throw new ClientIntegrationFormException("Company already exists");
        ClientIntegrationForm newClient = new ClientIntegrationForm();
        MerchantResponse response = new MerchantResponse();
        modelMapper.map(request, newClient);
//        newClient.setCompanyInformation(request.getCompanyInformation());
//        newClient.setContactInformation(request.getContactInformation());
//        newClient.setExtendedInformation(request.getExtendedInformation());
//        newClient.setSettlementAccountDetails(request.getSettlementAccountDetails());
//        newClient.setSystemAccess(request.getSystemAccess());
        log.info("i got here---------------------------->");
        repo.save(newClient);
        log.info("i got here---------------------------->");
        modelMapper.map(newClient, response);

        response.setMessage(newClient.getCompanyInformation().getBusinessName() + " registered successfully");

        return response;
    }
}

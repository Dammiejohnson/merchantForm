package com.catalyst.qIForm.dtos.requests;


import com.catalyst.qIForm.models.*;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class MerchantRequest {

    private CompanyInformation companyInformation;

    private ContactInformation contactInformation;

    private ExtendedInformation extendedInformation;

    private SettlementAccountDetails settlementAccountDetails;

    private SystemAccess systemAccess;
}

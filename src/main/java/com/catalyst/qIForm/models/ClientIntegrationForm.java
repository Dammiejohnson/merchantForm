package com.catalyst.qIForm.models;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "merchant_Form")
@Entity

public class ClientIntegrationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(targetEntity=CompanyInformation.class, fetch=FetchType.EAGER)
    private CompanyInformation companyInformation;

    @NotNull
    @OneToOne(targetEntity=ContactInformation.class, fetch=FetchType.EAGER)
    private ContactInformation contactInformation;

    @NotNull
    @OneToOne(targetEntity=ExtendedInformation.class, fetch=FetchType.EAGER)
    private ExtendedInformation extendedInformation;

    @NotNull
    @OneToOne(targetEntity=SettlementAccountDetails.class, fetch=FetchType.EAGER)
    private SettlementAccountDetails settlementAccountDetails;

    @NotNull
    @OneToOne(targetEntity=SystemAccess.class, fetch=FetchType.EAGER)
    private SystemAccess systemAccess;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientIntegrationForm clientIntegrationForm = (ClientIntegrationForm) o;
        return id != null && Objects.equals(id, clientIntegrationForm.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

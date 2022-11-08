package com.catalyst.qIForm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class CompanyInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regCode;
    private String businessName;
    private String businessAddress;
    private String websiteUrl;
    @OneToOne(targetEntity=RequiredService.class, fetch=FetchType.EAGER)
    private RequiredService requiredService;



}

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
public class SettlementAccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private String bankName;
    private String accountNumber;
    @OneToOne(targetEntity=PayFormat.class, fetch=FetchType.EAGER)
    private PayFormat payFormat;
    private String SVACardNumber;
}

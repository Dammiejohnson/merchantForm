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
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(targetEntity=PrimaryContactInformation.class, fetch=FetchType.EAGER)
    private PrimaryContactInformation primaryContactInformation;
    @OneToOne(targetEntity=SecondaryContactInformation.class, fetch=FetchType.EAGER)
    private SecondaryContactInformation secondaryContactInformation;


}

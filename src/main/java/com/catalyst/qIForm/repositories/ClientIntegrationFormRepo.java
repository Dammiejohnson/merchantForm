package com.catalyst.qIForm.repositories;

import com.catalyst.qIForm.models.ClientIntegrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientIntegrationFormRepo extends JpaRepository<ClientIntegrationForm, Long> {
//    Optional<ClientIntegrationForm> findByCompanyName(String nameOfCompany);
//    Optional<ClientIntegrationForm> findByCompanyRegcode(String regCode);
}

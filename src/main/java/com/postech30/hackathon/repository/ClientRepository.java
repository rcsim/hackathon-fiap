package com.postech30.hackathon.repository;

import com.postech30.hackathon.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findByCountryIgnoreCaseContainingOrCpfIgnoreCaseContainingOrPassportIgnoreCaseContainingOrFullNameIgnoreCaseContainingOrBirthDateIgnoreCaseContainingOrAddressIgnoreCaseContainingOrPhoneIgnoreCaseContainingOrEmailIgnoreCaseContaining(String country, String cpf, String passport, String fullName, String birthDate, String address, String phone, String email, Pageable pageable);
}

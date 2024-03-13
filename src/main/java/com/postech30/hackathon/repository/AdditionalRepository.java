package com.postech30.hackathon.repository;

import com.postech30.hackathon.entity.Additional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalRepository extends JpaRepository<Additional, Long> {

    Page<Additional> findByNameIgnoreCaseOrDescriptionIgnoreCaseOrPriceIgnoreCaseOrTypeIgnoreCase(String name, String description, Double price, String type, Pageable pageable);

}

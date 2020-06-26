package com.java.assistencia.repository.phone.impl;

import com.java.assistencia.domain.phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepositoryJpa extends JpaRepository<Phone, Long> {
}

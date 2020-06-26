package com.java.assistencia.repository.phone.impl;

import com.java.assistencia.domain.phone.Phone;
import com.java.assistencia.exception.NotFoundException;
import com.java.assistencia.repository.phone.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PhoneRepositoryImpl implements PhoneRepository {

    @Autowired
    private PhoneRepositoryJpa jpa;

    @Override
    public Phone findById(Long id) {
        Optional<Phone> result = jpa.findById(id);
        return result.orElseThrow(()-> new NotFoundException("Telefone não encontrado"));
    }
}

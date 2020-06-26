package com.java.assistencia.repository.phone;

import com.java.assistencia.domain.phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PhoneRepository {

    Phone findById(Long id);
}

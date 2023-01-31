package com.phone.service.business;

import com.phone.service.dto.Company;

/**
 * Service definition to manage the information about.
 */
public interface CompanyService {

    void create(Company company);

    void update(Company company);

    Company getById(Long id);
}

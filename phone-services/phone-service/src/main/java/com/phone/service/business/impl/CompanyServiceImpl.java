package com.phone.service.business.impl;

import com.phone.service.business.CompanyService;
import com.phone.service.dao.CompanyDAO;
import com.phone.service.dto.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDao;

    @Override
    public void create(Company company) {
        this.companyDao.create(company);
    }

    @Override
    public void update(Company company) {
        this.companyDao.update(company);
    }

    @Override
    public Company getById(Long id) {
        return this.companyDao.findById(id);
    }
}

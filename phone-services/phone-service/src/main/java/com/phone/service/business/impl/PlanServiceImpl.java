package com.phone.service.business.impl;

import com.phone.service.business.CompanyService;
import com.phone.service.business.PlanService;
import com.phone.service.dao.CompanyDAO;
import com.phone.service.dao.PlanDAO;
import com.phone.service.dto.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDAO planDao;

    @Autowired
    private CompanyService companyService;

    @Override
    public void create(Plan plan) {
        this.planDao.create(plan);
    }

    @Override
    public void update(Plan plan) {
        this.planDao.update(plan);
    }

    @Override
    public void delete(Long id) {
        this.planDao.delete(id);
    }

    @Override
    public Plan getById(Long id) {
        Plan plan = this.planDao.findById(id);
        plan.setCompany(this.companyService.getById(plan.getCompany().getId()));

        return plan;
    }
}

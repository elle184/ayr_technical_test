package com.phone.service.business;

import com.phone.service.dto.Plan;

/**
 * Service definition to manage the information about.
 */
public interface PlanService {

    void create(Plan plan);

    void update(Plan plan);

    void delete(Long id);

    Plan getById(Long id);
}

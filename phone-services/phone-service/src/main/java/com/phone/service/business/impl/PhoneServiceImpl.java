package com.phone.service.business.impl;

import com.phone.service.business.ClientService;
import com.phone.service.business.PhoneService;
import com.phone.service.business.PlanService;
import com.phone.service.dao.ClientDAO;
import com.phone.service.dao.PhoneServiceDAO;
import com.phone.service.dto.PhoneServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * </strong>PhoneServiceImpl</strong>
 *
 * @author <a href="mailto:oficialseb@gmail.com">Solo En Binario</a>
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PlanService planService;

    @Autowired
    private PhoneServiceDAO phoneServiceDao;

    @Autowired
    private ClientDAO clientDao;

    @Override
    public void create(PhoneServiceDTO phoneService) {
        this.phoneServiceDao.create(phoneService);
    }

    @Override
    public void update(PhoneServiceDTO phoneService) {
        this.phoneServiceDao.update(phoneService);
    }

    @Override
    public void delete(PhoneServiceDTO phoneService) {
        this.phoneServiceDao.delete(phoneService);
    }

    @Override
    public List<PhoneServiceDTO> getByClient(Long clientId) {
        return this.phoneServiceDao.findByClient(clientId);
    }

    @Override
    public PhoneServiceDTO getByClientAndPhoneNumber(Long clientId, Integer phoneNumber) {
        PhoneServiceDTO phoneService = this.phoneServiceDao
            .findByClientAndPhoneNumber(clientId, phoneNumber);
        phoneService.setClient(this.clientDao.findById(clientId));
        phoneService.setPlan(this.planService.getById(phoneService.getPlan().getId()));

        return phoneService;
    }
}

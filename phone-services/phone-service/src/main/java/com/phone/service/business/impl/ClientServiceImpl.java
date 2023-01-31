package com.phone.service.business.impl;

import com.phone.service.business.ClientService;
import com.phone.service.dao.ClientDAO;
import com.phone.service.dto.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDao;

    @Override
    public void create(Client client) {
        this.clientDao.create(client);
    }

    @Override
    public void update(Client client) {
        this.clientDao.update(client);
    }

    @Override
    public Client getBySecurityCode(String securityCode) {
        return this.clientDao.findBySecurityCode(securityCode);
    }
}

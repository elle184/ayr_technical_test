package com.phone.service.business;

import com.phone.service.dto.Client;

public interface ClientService {

    void create(Client client);

    void update(Client client);

    Client getBySecurityCode(String securityCode);
}

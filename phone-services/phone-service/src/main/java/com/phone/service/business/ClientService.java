package com.phone.service.business;

import com.phone.service.dto.Client;

/**
 * </strong></strong>
 *
 * @author <a href="mailto:abecerra@redesis.com">Adrian Becerra</a>
 * @version 7
 * @since 7
 */
public interface ClientService {

    void create(Client client);

    void update(Client client);

    Client getBySecurityCode(String securityCode);
}

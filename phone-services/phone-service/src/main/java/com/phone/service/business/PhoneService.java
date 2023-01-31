package com.phone.service.business;

import com.phone.service.dto.PhoneServiceDTO;

import java.util.List;

/**
 * Service definition to manage the information about.
 */
public interface PhoneService {

    void create(PhoneServiceDTO phoneService);

    void update(PhoneServiceDTO phoneService);

    void delete(PhoneServiceDTO phoneService);

    List<PhoneServiceDTO> getByClient(Long clientId);

    PhoneServiceDTO getByClientAndPhoneNumber(Long clientId, Integer phoneNumber);
}

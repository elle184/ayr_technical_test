package com.seb.phone.store.business;

import com.seb.phone.store.persistence.entity.Model;

import java.util.List;
import javax.ejb.Local;

/**
 * Service definition to manage the information about.
 */
@Local
public interface ModelService {

    List<Model> getAll();
}

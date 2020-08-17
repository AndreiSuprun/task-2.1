package org.suprun.filesearch.dao;

import org.suprun.filesearch.entity.Appliance;

import java.util.List;

public interface ApplianceDao {

    List<Appliance> findByParameter(String parameter, String value) throws DaoException;

}

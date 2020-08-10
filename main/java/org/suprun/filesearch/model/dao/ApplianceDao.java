package org.suprun.filesearch.model.dao;

import org.suprun.filesearch.model.entity.Appliance;

import java.util.List;

public interface ApplianceDao {

    List<Appliance> findByParameter(String parameter, String value);

}

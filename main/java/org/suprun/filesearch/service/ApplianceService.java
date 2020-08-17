package org.suprun.filesearch.service;

import org.suprun.filesearch.entity.Appliance;

import java.util.List;
import java.util.Map;

public interface ApplianceService {

    List<Appliance> findByParameter(Map<String, String> request) throws ServiceException;
}

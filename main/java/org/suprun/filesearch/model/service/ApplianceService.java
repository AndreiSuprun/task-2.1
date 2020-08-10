package org.suprun.filesearch.model.service;

import org.suprun.filesearch.model.dao.ApplianceDao;
import org.suprun.filesearch.model.dao.impl.ApplianceDaoImpl;
import org.suprun.filesearch.model.entity.Appliance;
import org.suprun.filesearch.model.exception.ServiceException;

import java.util.List;
import java.util.Map;

public class ApplianceService {

    ApplianceDao applianceDao = new ApplianceDaoImpl();

    public List<Appliance> findByParameter(Map<String, String> request) throws ServiceException {
        String parameter = request.get("parameter");
        String value = request.get("value");
        if(parameter ==null || value ==null || parameter.isEmpty() || value.isEmpty()){
            throw new ServiceException("Invalid parameter");
        }
        List<Appliance> appliances = applianceDao.findByParameter(parameter, value);
        return appliances;
    }
}
package org.suprun.filesearch.service.impl;

import org.suprun.filesearch.dao.ApplianceDao;
import org.suprun.filesearch.dao.DaoException;
import org.suprun.filesearch.dao.DaoFactory;
import org.suprun.filesearch.entity.Appliance;
import org.suprun.filesearch.service.ServiceException;
import org.suprun.filesearch.service.ApplianceService;

import java.util.List;
import java.util.Map;

public class ApplianceServiceImpl implements ApplianceService {

    private static String PARAMETER = "parameter";
    private static String VALUE = "value";

    public List<Appliance> findByParameter(Map<String, String> request) throws ServiceException {
        String parameter = request.get(PARAMETER);
        String value = request.get(VALUE);
        if(parameter ==null || value ==null || parameter.isEmpty() || value.isEmpty()){
            throw new ServiceException("Invalid parameter");
        }
        DaoFactory factory = DaoFactory.getInstance();
        ApplianceDao applianceDao = factory.getApplianceDao();
        try{
            return applianceDao.findByParameter(parameter, value);
        } catch (DaoException e){
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
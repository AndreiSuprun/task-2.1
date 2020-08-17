package org.suprun.filesearch.dao.impl;

import org.suprun.filesearch.dao.DaoException;
import org.suprun.filesearch.dao.creator.ApplianceCreator;
import org.suprun.filesearch.dao.ApplianceDao;
import org.suprun.filesearch.entity.Appliance;
import org.suprun.filesearch.dao.source.ApplianceSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceDaoImpl implements ApplianceDao {

    @Override
    public List<Appliance> findByParameter(String parameter, String value) throws DaoException {
        String parameterSelector = String.format(".*%s[=]%s[,\\s+].*", parameter, value);
        Stream<String> applianceStream = new ApplianceSource().receiveApplianceStream();
        ApplianceCreator applianceCreator = new ApplianceCreator();
        List<Appliance> appliances = applianceStream.filter(line -> (line.contains(parameter) && line.matches(parameterSelector)))
                .map(applianceCreator::createAppliance).collect(Collectors.toList());
        return appliances;
    }
}

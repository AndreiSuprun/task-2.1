package org.suprun.filesearch.model.dao.impl;

import org.suprun.filesearch.model.creator.ApplianceCreator;
import org.suprun.filesearch.model.dao.ApplianceDao;
import org.suprun.filesearch.model.entity.Appliance;
import org.suprun.filesearch.model.source.ApplianceSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceDaoImpl implements ApplianceDao {

    @Override
    public List<Appliance> findByParameter(String parameter, String value) {
        String parameterSelector = String.format(".*%s[=]%s[,\\s+].*", parameter, value);
        Stream<String> applianceStream = new ApplianceSource().receiveApplianceStream();
        ApplianceCreator applianceCreator = new ApplianceCreator();
        List<Appliance> appliances = applianceStream.filter(line -> (line.contains(parameter) && line.matches(parameterSelector)))
                .map(applianceCreator::createAppliance).collect(Collectors.toList());
        return appliances;
    }
}

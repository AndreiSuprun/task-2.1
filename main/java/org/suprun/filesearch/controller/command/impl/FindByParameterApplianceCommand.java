package org.suprun.filesearch.controller.command.impl;

import org.suprun.filesearch.controller.command.ApplianceCommand;
import org.suprun.filesearch.entity.Appliance;
import org.suprun.filesearch.service.ServiceException;
import org.suprun.filesearch.service.ApplianceService;
import org.suprun.filesearch.service.ServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindByParameterApplianceCommand implements ApplianceCommand {

    private static String APPLIANCES = "appliances";
    private static String EXCEPTIONS = "exceptions";

    @Override
    public Map<String, Object> execute(Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService applianceService = factory.getApplianceService();
        try{
            List<Appliance> appliances = applianceService.findByParameter(request);
            response.put(APPLIANCES, appliances);
        } catch (ServiceException e){
            response.put(EXCEPTIONS, e.getMessage());
        }
        return response;
    }
}

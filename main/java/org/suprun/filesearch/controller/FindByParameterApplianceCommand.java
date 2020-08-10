package org.suprun.filesearch.controller;

import org.suprun.filesearch.model.entity.Appliance;
import org.suprun.filesearch.model.exception.ServiceException;
import org.suprun.filesearch.model.service.ApplianceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindByParameterApplianceCommand implements ApplianceCommand{

    ApplianceService applianceService = new ApplianceService();

    @Override
    public Map<String, Object> execute(Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        try{
            List<Appliance> appliances = applianceService.findByParameter(request);
            response.put("appliances", appliances);
        } catch (ServiceException e){
            response.put("exceptions", e.getMessage());
        }
        return response;
    }
}

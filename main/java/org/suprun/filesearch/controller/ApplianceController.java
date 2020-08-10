package org.suprun.filesearch.controller;

import java.util.Map;

public class ApplianceController {

    public Map<String, Object> processRequest(Map<String, String> request) {
        ApplianceCommand applianceCommand = new FindByParameterApplianceCommand();
        Map<String, Object> response = applianceCommand.execute(request);
        return response;
    }
}

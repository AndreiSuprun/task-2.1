package org.suprun.filesearch.controller;

import org.suprun.filesearch.controller.command.ApplianceCommand;

import java.util.Map;

public class ApplianceController {

    public Map<String, Object> processRequest(Map<String, String> request) {
        ApplianceCommand applianceCommand = new CommandProvider().receiveCommand(request);
        Map<String, Object> response = applianceCommand.execute(request);
        return response;
    }
}

package org.suprun.filesearch.controller;

import org.suprun.filesearch.controller.command.ApplianceCommand;
import org.suprun.filesearch.controller.command.impl.EmptyApplianceCommand;
import org.suprun.filesearch.controller.command.impl.FindByParameterApplianceCommand;

import java.util.Map;

public class CommandProvider {

    private static final String REQUEST_TYPE = "request_type";

    public ApplianceCommand receiveCommand(Map<String, String> request){
        ApplianceCommand command;
        String request_type = request.get(REQUEST_TYPE);
        try {
        RequestType requestType = RequestType.valueOf(request_type.toUpperCase());
        command = requestType.getCommand();
    } catch (IllegalArgumentException e) {
        command = new EmptyApplianceCommand();
    }
        return command;
    }

    enum RequestType {
        FIND_BY_PARAMETER(new FindByParameterApplianceCommand());
        private final ApplianceCommand applianceCommand;
        RequestType(ApplianceCommand applianceCommand) {
            this.applianceCommand = applianceCommand;
        }
        public ApplianceCommand getCommand(){
            return  applianceCommand;
        }
    }
}

package org.suprun.filesearch.controller.command.impl;

import org.suprun.filesearch.controller.command.ApplianceCommand;

import java.util.HashMap;
import java.util.Map;

public class EmptyApplianceCommand implements ApplianceCommand {

    public Map<String, Object> execute(Map<String, String> request) {
        return new HashMap<String, Object>();
    };
}

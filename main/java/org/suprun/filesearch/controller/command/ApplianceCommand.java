package org.suprun.filesearch.controller.command;

import java.util.Map;

public interface ApplianceCommand {

    Map<String, Object> execute(Map<String, String> request);
}

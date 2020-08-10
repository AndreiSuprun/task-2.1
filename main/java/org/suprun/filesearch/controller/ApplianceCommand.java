package org.suprun.filesearch.controller;

import org.suprun.filesearch.model.entity.Appliance;

import java.util.List;
import java.util.Map;

public interface ApplianceCommand {

    Map<String, Object> execute(Map<String, String> request);
}

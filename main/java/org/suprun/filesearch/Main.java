package org.suprun.filesearch;

import org.suprun.filesearch.controller.ApplianceController;
import org.suprun.filesearch.model.entity.Appliance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ApplianceController controller = new ApplianceController();
        Map<String, String> request = new HashMap<>();
        request.put("parameter", "POWER_CONSUMPTION");
        request.put("value", "100");
        Map<String, Object> response = controller.processRequest(request);
        if (response.get("appliances") != null) {
            List<Appliance> list = (List<Appliance>) response.get("appliances");
            System.out.println(list.toString());
        } else {
            System.out.println(response.get("exceptions").toString());
        }
    }
}

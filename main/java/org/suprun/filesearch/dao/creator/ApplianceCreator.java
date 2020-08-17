package org.suprun.filesearch.dao.creator;

import org.suprun.filesearch.entity.*;
import org.suprun.filesearch.dao.parser.ApplianceParser;

public class ApplianceCreator {

    enum ApplianceType{
        LAPTOP("Laptop"), OVEN("Oven"), REFRIGERATOR("Refrigerator"), SPEAKERS("Speakers"), TABLETPC("TabletPC"),
        VACUUMCLEANER("VacuumCleaner");
        private String type;
        ApplianceType(String type){
            this.type = type;
        }
        public String getType(){
            return type;
        }
    }

    public Appliance createAppliance(String line){
        ApplianceParser applianceParser = new ApplianceParser();
        String applianceType = applianceParser.extractApplianceType(line);
        Appliance appliance = null;
        switch (ApplianceType.valueOf(applianceType.toUpperCase())){
            case LAPTOP: {
                appliance = applianceParser.parseLaptop(line);
                return appliance;
            }
            case OVEN: {
                appliance = applianceParser.parseOven(line);
                return appliance;
            }
            case REFRIGERATOR: {
                appliance = applianceParser.parseRefrigerator(line);
                return appliance;
            }
            case SPEAKERS: {
                appliance = applianceParser.parseSpeakers(line);
                return appliance;
            }
            case TABLETPC: {
                appliance = applianceParser.parseTabletPC(line);
                return appliance;
            }
            case VACUUMCLEANER: {
                appliance = applianceParser.parseVacuumCleaner(line);
                return appliance;
            }
        }
        return appliance;
    }
}

package org.suprun.filesearch.model.parser;

import org.suprun.filesearch.model.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceParser {

    private static final String APPLIANCE_TYPE_SELECTOR = "\\b\\w+";
    private static final String PARAMETER_VALUE_SELECTOR = ".*%s[=]([-\\w]*)[,\\s+]*.*";

    public Laptop parseLaptop(String line) {
        double batteryCapacity = parseDoubleValue(extractValue(line, LaptopParameters.BATTERY_CAPACITY));
        Laptop.Os os = Laptop.Os.valueOf(extractValue(line, LaptopParameters.OS));
        int memoryRom = parseIntValue(extractValue(line, LaptopParameters.MEMORY_ROM));
        int systemMemory = parseIntValue(extractValue(line, LaptopParameters.SYSTEM_MEMORY));
        double cpu = parseDoubleValue(extractValue(line, LaptopParameters.CPU));
        int displayInches = parseIntValue(extractValue(line, LaptopParameters.DISPLAY_INCHES));
        Laptop laptop = new Laptop(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
        return laptop;
    }

    public Oven parseOven(String line) {
        int powerConsumption = parseIntValue(extractValue(line, OvenParameters.POWER_CONSUMPTION));
        int weight = parseIntValue(extractValue(line, OvenParameters.WEIGHT));
        int capacity = parseIntValue(extractValue(line, OvenParameters.CAPACITY));
        int depth = parseIntValue(extractValue(line, OvenParameters.DEPTH));
        int height = parseIntValue(extractValue(line, OvenParameters.HEIGHT));
        int width = parseIntValue(extractValue(line, OvenParameters.WIDTH));
        Oven oven = new Oven(powerConsumption, weight, capacity, depth, height, width);
        return oven;
    }

    public Refrigerator parseRefrigerator(String line) {
        int powerConsumption = parseIntValue(extractValue(line, RefrigeratorParameters.POWER_CONSUMPTION));
        int weight = parseIntValue(extractValue(line, RefrigeratorParameters.WEIGHT));
        int freezerCapacity = parseIntValue(extractValue(line, RefrigeratorParameters.FREEZER_CAPACITY));
        int overallCapacity = parseIntValue(extractValue(line, RefrigeratorParameters.OVERALL_CAPACITY));
        int height = parseIntValue(extractValue(line, RefrigeratorParameters.HEIGHT));
        int width = parseIntValue(extractValue(line, RefrigeratorParameters.WIDTH));
        Refrigerator refrigerator = new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
        return refrigerator;
    }

    public Speakers parseSpeakers(String line) {
        int powerConsumption = parseIntValue(extractValue(line, SpeakersParameters.POWER_CONSUMPTION));
        int numberOfSpeakers = parseIntValue(extractValue(line, SpeakersParameters.NUMBER_OF_SPEAKERS));
        String frequencyRange = extractValue(line, SpeakersParameters.FREQUENCY_RANGE);
        int cordLength = parseIntValue(extractValue(line, SpeakersParameters.CORD_LENGTH));
        Speakers speakers = new Speakers(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
        return speakers;
    }

    public TabletPC parseTabletPC(String line) {
        double batteryCapacity = parseDoubleValue(extractValue(line, TabletPCParameters.BATTERY_CAPACITY));
        int displayInches = parseIntValue(extractValue(line, TabletPCParameters.DISPLAY_INCHES));
        int memoryRom = parseIntValue(extractValue(line, TabletPCParameters.MEMORY_ROM));
        int flashMemoryCapacity = parseIntValue(extractValue(line, TabletPCParameters.FLASH_MEMORY_CAPACITY));
        TabletPC.Color color = TabletPC.Color.valueOf(extractValue(line, TabletPCParameters.COLOR));
        TabletPC tabletPC = new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
        return tabletPC;
    }

    public VacuumCleaner parseVacuumCleaner(String line) {
        int powerConsumption = parseIntValue(extractValue(line, VacuumCleanerParameters.POWER_CONSUMPTION));
        VacuumCleaner.FilterType filterType = VacuumCleaner.FilterType.valueOf(extractValue(line,
                VacuumCleanerParameters.FILTER_TYPE));
        VacuumCleaner.BagType bagType = VacuumCleaner.BagType.valueOf(extractValue(line,
                VacuumCleanerParameters.BAG_TYPE));
        String wandType = extractValue(line, VacuumCleanerParameters.WAND_TYPE);
        int motorSpeedRegulation = parseIntValue(extractValue(line, VacuumCleanerParameters.MOTOR_SPEED_REGULATION));
        int cleaningWidth = parseIntValue(extractValue(line, VacuumCleanerParameters.CLEANING_WIDTH));
        VacuumCleaner vacuumCleaner = new VacuumCleaner(powerConsumption, filterType, bagType, wandType,
                motorSpeedRegulation, cleaningWidth);
        return vacuumCleaner;
    }

    private double parseDoubleValue(String value) {
        if (value == null || value.isEmpty()) {
            return 0.0;
        }
        double doubleValue;
        try {
            doubleValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
        return doubleValue;
    }

    private int parseIntValue(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }
        int intValue;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
        return intValue;
    }

    private String extractValue(String line, String parameter) {
        String valueSelector = String.format(PARAMETER_VALUE_SELECTOR, parameter);
        Pattern pattern = Pattern.compile(valueSelector);
        Matcher matcher = pattern.matcher(line);
        String value = "";
        if (matcher.find()){
            value = matcher.group(1).trim();
        }
        return value;
    }

    public String extractApplianceType(String line) {
        Pattern pattern = Pattern.compile(APPLIANCE_TYPE_SELECTOR);
        Matcher matcher = pattern.matcher(line);
        String value = "";
        if (matcher.find()){
        value = matcher.group().trim();
        }
        return value;
    }
}

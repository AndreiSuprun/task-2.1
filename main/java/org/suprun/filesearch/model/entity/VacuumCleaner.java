package org.suprun.filesearch.model.entity;

public class VacuumCleaner extends Appliance{

    private int powerConsumption;
    private FilterType filterType;
    private BagType bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public enum FilterType{
        A("A"), B("B"), C("C");
        private final String type;
        FilterType(String type){
            this.type = type;
        };
        public String getType(){
            return type;
        }
    }

    public enum BagType{
        A2("A2"), AA_89("AA-89"), XX00("XX00");
        private final String type;
        BagType(String type){
            this.type = type;
        }
        public String getType(){
            return type;
        }
    }

    public VacuumCleaner(int powerConsumption, FilterType filterType, BagType bagType, String wandType,
                         int motorSpeedRegulation, int cleaningWidth) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public BagType getBagType() {
        return bagType;
    }

    public void setBagType(BagType bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VacuumCleaner that = (VacuumCleaner) o;
        if (powerConsumption != that.powerConsumption) {
            return false;
        }
        if (motorSpeedRegulation != that.motorSpeedRegulation) {
            return false;
        }
        if (cleaningWidth != that.cleaningWidth) {
            return false;
        }
        if (filterType != that.filterType) {
            return false;
        }
        if (bagType != that.bagType) {
            return false;
        }
        return wandType != null ? wandType.equals(that.wandType) : that.wandType == null;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + (filterType != null ? filterType.hashCode() : 0);
        result = 31 * result + (bagType != null ? bagType.hashCode() : 0);
        result = 31 * result + (wandType != null ? wandType.hashCode() : 0);
        result = 31 * result + motorSpeedRegulation;
        result = 31 * result + cleaningWidth;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VacuumCleaner {");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", filterType=").append(filterType);
        sb.append(", bagType=").append(bagType);
        sb.append(", wandType='").append(wandType);
        sb.append(", motorSpeedRegulation=").append(motorSpeedRegulation);
        sb.append(", cleaningWidth=").append(cleaningWidth);
        sb.append('}');
        return sb.toString();
    }
}

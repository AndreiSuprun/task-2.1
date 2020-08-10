package org.suprun.filesearch.model.entity;

public class TabletPC extends Appliance{

    private double batteryCapacity;
    private int displayInches;
    private int memoryRom;
    private int flashMemoryCapacity;
    private Color color;

    public enum Color{
        BLUE("blue"), GREEN("green"), RED("red");
        private String color;
        Color(String color){
            this.color = color;
        }
        public String getColor(){
            return color;
        }
    }

    public TabletPC(double batteryCapacity, int displayInches, int memoryRom, int flashMemoryCapacity, Color color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TabletPC tabletPC = (TabletPC) o;
        if (Double.compare(tabletPC.batteryCapacity, batteryCapacity) != 0) {
            return false;
        }
        if (displayInches != tabletPC.displayInches) {
            return false;
        }
        if (memoryRom != tabletPC.memoryRom) {
            return false;
        }
        if (flashMemoryCapacity != tabletPC.flashMemoryCapacity) {
            return false;
        }
        return color == tabletPC.color;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + displayInches;
        result = 31 * result + memoryRom;
        result = 31 * result + flashMemoryCapacity;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TabletPC {");
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", displayInches=").append(displayInches);
        sb.append(", memoryRom=").append(memoryRom);
        sb.append(", flashMemoryCapacity=").append(flashMemoryCapacity);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}

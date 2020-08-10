package org.suprun.filesearch.model.entity;

public class Oven extends Appliance{

    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private int height;
    private int width;

    public Oven(int powerConsumption, int weight, int capacity, int depth, int height, int width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Oven oven = (Oven) o;
        if (powerConsumption != oven.powerConsumption) {
            return false;
        }
        if (weight != oven.weight) {
            return false;
        }
        if (capacity != oven.capacity) {
            return false;
        }
        if (depth != oven.depth) {
            return false;
        }
        if (height != oven.height) {
            return false;
        }
        return width == oven.width;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + weight;
        result = 31 * result + capacity;
        result = 31 * result + depth;
        result = 31 * result + height;
        result = 31 * result + width;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Oven {");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", weight=").append(weight);
        sb.append(", capacity=").append(capacity);
        sb.append(", depth=").append(depth);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }
}

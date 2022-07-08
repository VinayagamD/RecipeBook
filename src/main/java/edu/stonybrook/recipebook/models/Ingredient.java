package edu.stonybrook.recipebook.models;

import java.util.Objects;

public class Ingredient {

    private String name;
    private String measuringUnit;
    private int caloriesPerUnit;

    public Ingredient(String name, String measuringUnit, int caloriesPerUnit) {
        this.name = name;
        this.measuringUnit = measuringUnit;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public String getName() {
        return name;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public int getCaloriesPerUnit() {
        return caloriesPerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return caloriesPerUnit == that.caloriesPerUnit && Objects.equals(name, that.name) && Objects.equals(measuringUnit, that.measuringUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, measuringUnit, caloriesPerUnit);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", measuringUnit='" + measuringUnit + '\'' +
                ", caloriesPerUnit=" + caloriesPerUnit +
                '}';
    }
}

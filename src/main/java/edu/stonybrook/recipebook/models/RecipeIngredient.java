package edu.stonybrook.recipebook.models;

public class RecipeIngredient extends Ingredient {

    private float quantity;

    public RecipeIngredient(String name, String measuringUnit, int caloriesPerUnit, float quantity) {
        super(name, measuringUnit, caloriesPerUnit);
        this.quantity = quantity;
    }

    public RecipeIngredient(Ingredient ingredient, float quantity) {
        super(ingredient.getName(), ingredient.getMeasuringUnit(), ingredient.getCaloriesPerUnit());
        this.quantity = quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "ingredient=" + super.toString()+
                "quantity=" + quantity +
                '}';
    }
}

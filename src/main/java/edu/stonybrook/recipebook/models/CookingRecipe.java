package edu.stonybrook.recipebook.models;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CookingRecipe {
    private  List<RecipeIngredient> ingredients;
    private String name;

    public CookingRecipe(String name) {
        this.name = name;
    }

    public boolean validateIngredient() {
        return ingredients == null || ingredients.isEmpty();
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void addOrUpdateRecipeIngredient(Ingredient ingredient, float quantity){
      Optional<RecipeIngredient> recipeIngredient =  ingredients.stream().filter(Objects::nonNull)
              .filter(recipesIngredient -> ((Ingredient) recipesIngredient)
                      .equals(ingredient)).findAny();
      if (recipeIngredient.isPresent()){
         ingredients.get(ingredients.indexOf(recipeIngredient.get())).setQuantity(quantity);
      } else {
          ingredients.add(new RecipeIngredient(ingredient, quantity));
      }
    }

    public RecipeIngredient getRecipeIngredient(String ingredientName) {
      return  ingredients.stream()
              .filter(ingredient ->ingredient.getName().equals(ingredientName))
              .findAny().orElse(null);
    }

    public float calculateCalories() {
        return (float) ingredients.stream().mapToDouble(ingredient ->  ingredient.getCaloriesPerUnit() * ingredient.getQuantity()).sum();
    }

    public int getNumberOfIngredients() {
        return ingredients.size();
    }

    @Override
    public String toString() {
        return "CookingRecipe{" +
                "name='" + name + '\'' +
                ",ingredients=" + ingredients.stream().map(Ingredient::getName).toList() +
                '}';
    }
}

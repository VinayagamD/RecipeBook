package edu.stonybrook.recipebook.models;

import java.util.*;
import java.util.stream.Collectors;

public class RecipeBook {

    private String name;
    private Map<String, CookingRecipe> cookingRecipes = new HashMap<>();

    public RecipeBook(String name) {
        this.name = name;
    }

    public void addRecipe(String name, RecipeIngredient[] recipeIngredients) {
        CookingRecipe cookingRecipe = new CookingRecipe(name);
        cookingRecipe.setIngredients(Arrays.asList(recipeIngredients));
        cookingRecipes.put(name, cookingRecipe);
    }

    public CookingRecipe removeRecipe(String name) {
        return cookingRecipes.remove(name);
    }

    public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients) {
        List<RecipeIngredient> recipeIngredients = Arrays.asList(ingredients);
        List<CookingRecipe> cookingRecipeList = cookingRecipes.values().stream().filter(cookingRecipe -> cookingRecipe.getIngredients().stream().anyMatch(recipeIngredients::contains)).collect(Collectors.toList());
        if (cookingRecipeList.isEmpty()) {
            return null;
        } else {
            return cookingRecipeList.toArray(new CookingRecipe[0]);
        }
    }

    public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients) {
        List<CookingRecipe> cookingRecipeList = cookingRecipes.values().stream().filter(cookingRecipe -> cookingRecipe.getIngredients().size() >= numberOfIngredients).toList();
        if (cookingRecipeList.isEmpty()) {
            return null;
        } else {
            return cookingRecipeList.toArray(new CookingRecipe[0]);
        }
    }

    public CookingRecipe[] findRecipesLowCalories() {
        float lowCalories = (float) cookingRecipes.values().stream().mapToDouble(CookingRecipe::calculateCalories).min().orElse(0.0);
        List<CookingRecipe> cookingRecipeList = cookingRecipes.values().stream().filter(cookingRecipe -> cookingRecipe.calculateCalories() == lowCalories).toList();
        if (cookingRecipeList.isEmpty()) {
            return null;
        } else {
            return cookingRecipeList.toArray(new CookingRecipe[0]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeBook that = (RecipeBook) o;
        return Objects.equals(name, that.name) && Objects.equals(cookingRecipes, that.cookingRecipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cookingRecipes);
    }

    @Override
    public String toString() {
        return "RecipeBook{" +
                "name='" + name + '\'' +
                ", cookingRecipes=" + cookingRecipes +
                '}';
    }
}

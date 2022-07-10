package edu.stonybrook.recipebook.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public CookingRecipe removeRecipe(String name){
        return cookingRecipes.remove(name);
    }

    public CookingRecipe[] findRecipes(RecipeIngredient[] ingredients) {
        List<RecipeIngredient> recipeIngredients = Arrays.asList(ingredients);
        List<CookingRecipe> cookingRecipeList =cookingRecipes.values().stream().filter(cookingRecipe -> cookingRecipe.getIngredients().stream().anyMatch(recipeIngredients::contains)).collect(Collectors.toList());
        if (cookingRecipeList.isEmpty()){
            return null;
        } else {
            return cookingRecipeList.toArray(new CookingRecipe[0]);
        }
    }

    public CookingRecipe[] findRecipesWithFewIngredients(int numberOfIngredients) {
        List<CookingRecipe> cookingRecipeList = cookingRecipes.values().stream().filter(cookingRecipe -> cookingRecipe.getIngredients().size() >= numberOfIngredients).toList();
        if (cookingRecipeList.isEmpty()){
            return null;
        } else {
            return cookingRecipeList.toArray(new CookingRecipe[0]);
        }
    }
}

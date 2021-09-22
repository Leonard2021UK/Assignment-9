package com.codercampus.csvApp.intrfaces;

import com.codercampus.csvApp.domain.Recipe;

import java.util.List;

public interface RecipeRepository {

    /**
     * Stores a recipe
     * @param recipe a recipe to store
     */
    void storeRecipe(Recipe recipe);

    /**
     * Return all recipes stored in the repository
     * @return
     */
    List<Recipe> getAllRecipe();

    /**
     * Returns only the recipes which are gluten free
     * @return
     */
    List<Recipe> getGlutenFreeRecipes();

    /**
     *      * Returns only the recipes which are vegan
     * @return
     */
    List<Recipe> getVeganRecipes();

    /**
     *      * Returns only the recipes which are vegetarian
     * @return
     */
    List<Recipe> getVegetarianRecipes();

    /**
     * Returns only the recipes which are gluten free and vegetarian
     * @return
     */
    List<Recipe> getVegetarianAndGlutenFreeRecipes();


}

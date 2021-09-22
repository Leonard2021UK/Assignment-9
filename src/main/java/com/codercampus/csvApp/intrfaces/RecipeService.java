package com.codercampus.csvApp.intrfaces;

import com.codercampus.csvApp.domain.Recipe;

public interface RecipeService {

    /**
     * Stores the a Recipe in the repository
     * @param recipe = a newly created Recipe
     */
    void storeRecipe(Recipe recipe);

    /**
     * populates data in repository read from a file
     */
    void seedDataFromFile();
}

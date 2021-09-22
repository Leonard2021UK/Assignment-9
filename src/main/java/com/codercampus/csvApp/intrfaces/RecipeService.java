package com.codercampus.csvApp.intrfaces;

import com.codercampus.csvApp.domain.Recipe;

public interface RecipeService {


    /**
     * populates data in repository read from a file
     */
    void storeRecipes();
}

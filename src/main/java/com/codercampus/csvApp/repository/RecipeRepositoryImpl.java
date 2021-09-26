package com.codercampus.csvApp.repository;

import com.codercampus.csvApp.domain.Recipe;
import com.codercampus.csvApp.appInterface.RecipeRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    List<Recipe> recipeCollection = new ArrayList<>();

    public void storeRecipe(Recipe recipe) {

        recipeCollection.add(recipe);
    }

    public List<Recipe> getAllRecipes(){
        return this.recipeCollection;
    }


    public List<Recipe> getGlutenFreeRecipes(){
       return this.recipeCollection.stream().filter((Recipe::getGlutenFree)).collect(Collectors.toList());
    };

    public List<Recipe> getVeganRecipes(){
        return this.recipeCollection.stream().filter((Recipe::getVegan)).collect(Collectors.toList());
    };

    public List<Recipe> getVegetarianRecipes(){
        return this.recipeCollection.stream().filter((Recipe::getVegetarian)).collect(Collectors.toList());
    };

    public List<Recipe> getVeganAndGlutenFreeRecipes(){
        return this.recipeCollection.stream().filter((recipe -> recipe.getGlutenFree() && recipe.getVegan())).collect(Collectors.toList());
    };

}

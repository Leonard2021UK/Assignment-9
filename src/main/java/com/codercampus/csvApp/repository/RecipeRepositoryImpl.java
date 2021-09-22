package com.codercampus.csvApp.repository;

import com.codercampus.csvApp.domain.Recipe;
import com.codercampus.csvApp.intrfaces.RecipeRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    List<Recipe> recipeCollection = new ArrayList<>();

    public void storeRecipe(Recipe recipe) {

        recipeCollection.add(recipe);
    }


    public List<Recipe> getAllRecipe(){
        return this.recipeCollection;
    }


    public List<Recipe> getGlutenFreeRecipes(){
        List<Recipe> glutenFreeRecipes = new ArrayList<>();
        for(Recipe recipe:this.recipeCollection){
            if(recipe.getGlutenFree()){
                glutenFreeRecipes.add(recipe);
            }
        }
        return glutenFreeRecipes;
    };
    public List<Recipe> getVeganRecipes(){
        List<Recipe> veganRecipes = new ArrayList<>();
        for(Recipe recipe:this.recipeCollection){
            if(recipe.getVegan()){
                veganRecipes.add(recipe);
            }
        }
        return veganRecipes;
    };

    public List<Recipe> getVegetarianRecipes(){
        List<Recipe> vegetarianRecipes = new ArrayList<>();
        for(Recipe recipe:this.recipeCollection){
            if(recipe.getVegan()){
                vegetarianRecipes.add(recipe);
            }
        }
        return vegetarianRecipes;
    };

    public List<Recipe> getVegetarianAndGlutenFreeRecipes(){
        List<Recipe> veganAndGlutenFreeRecipes = new ArrayList<>();
        for(Recipe recipe:this.recipeCollection){
            if(recipe.getVegan() && recipe.getGlutenFree()){
                veganAndGlutenFreeRecipes.add(recipe);
            }
        }
        return veganAndGlutenFreeRecipes;
    };

}

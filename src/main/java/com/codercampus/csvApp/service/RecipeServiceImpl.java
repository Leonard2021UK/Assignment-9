package com.codercampus.csvApp.service;


import com.codercampus.csvApp.domain.Recipe;
import com.codercampus.csvApp.appInterface.Factory;
import com.codercampus.csvApp.appInterface.FileService;
import com.codercampus.csvApp.appInterface.RecipeRepository;
import com.codercampus.csvApp.appInterface.RecipeService;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl  implements RecipeService {

    Factory<Recipe> recipeFactory;
    FileService fileService;
    RecipeRepository recipeRepo;

    @Autowired
    public RecipeServiceImpl(Factory<Recipe> recipeFactory, FileService fileService, RecipeRepository recipeRepository){
        this.recipeFactory = recipeFactory;
        this.fileService = fileService;
        this.recipeRepo = recipeRepository;
        this.storeRecipes();
    }


    public void storeRecipes(){
        try {
            Iterable<CSVRecord> recipes = this.fileService.readFile();
            for (CSVRecord recipeRecord : recipes) {
                Recipe recipe = this.recipeFactory.create(recipeRecord);
                this.recipeRepo.storeRecipe(recipe);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Recipe> getGlutenFreeRecipes() {
       return this.recipeRepo.getGlutenFreeRecipes();
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes(){
        return this.recipeRepo.getVeganAndGlutenFreeRecipes();
    }

    public List<Recipe> getVeganRecipes(){
        return this.recipeRepo.getVeganRecipes();
    }

    public List<Recipe> getVegetarianRecipes(){
        return this.recipeRepo.getVegetarianRecipes();
    }

    public List<Recipe> getAllRecipes(){
        return this.recipeRepo.getAllRecipes();
    }

}

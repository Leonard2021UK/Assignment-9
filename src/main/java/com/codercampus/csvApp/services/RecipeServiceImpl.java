package com.codercampus.csvApp.services;


import com.codercampus.csvApp.domain.Recipe;
import com.codercampus.csvApp.intrfaces.Factory;
import com.codercampus.csvApp.intrfaces.FileService;
import com.codercampus.csvApp.intrfaces.RecipeRepository;
import com.codercampus.csvApp.intrfaces.RecipeService;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        this.seedDataFromFile();
    }

    public void storeRecipe(Recipe recipe){
        this.recipeRepo.storeRecipe(recipe);
    }

    public void seedDataFromFile(){
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


}

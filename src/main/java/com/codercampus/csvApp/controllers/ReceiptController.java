package com.codercampus.csvApp.controllers;

import com.codercampus.csvApp.domain.Recipe;
import com.codercampus.csvApp.intrfaces.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/")
public class ReceiptController {

    RecipeRepository recipeRepository;

    @Autowired
    public ReceiptController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/gluten-free")
    public ResponseEntity<List<Recipe>> getGlutenFreeRecipes(){
        return new ResponseEntity<>(this.recipeRepository.getGlutenFreeRecipes(), HttpStatus.OK);
    }

    @GetMapping("/vegan")
    public ResponseEntity<List<Recipe>> getVeganRecipes(){
        return new ResponseEntity<>(this.recipeRepository.getVeganRecipes(), HttpStatus.OK);

    }

    @GetMapping("/vegan-and-gluten-free")
    public ResponseEntity<List<Recipe>> getVeganAndGlutenFreeRecipes(){
        return new ResponseEntity<>(this.recipeRepository.getVegetarianAndGlutenFreeRecipes(), HttpStatus.OK);

    }

    @GetMapping("/vegetarian")
    public ResponseEntity<List<Recipe>> getVegetarianRecipes(){
        return new ResponseEntity<>(this.recipeRepository.getVegetarianRecipes(), HttpStatus.OK);

    }

    @GetMapping("/all-recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes(){

        return new ResponseEntity<>(this.recipeRepository.getAllRecipe(), HttpStatus.OK);
    }
}

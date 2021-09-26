package com.codercampus.csvApp.controller;

import com.codercampus.csvApp.appInterface.RecipeService;
import com.codercampus.csvApp.domain.Recipe;
import com.codercampus.csvApp.appInterface.RecipeRepository;
import com.codercampus.csvApp.service.RecipeServiceImpl;
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

    RecipeServiceImpl recipeService;

    @Autowired
    public ReceiptController(RecipeServiceImpl recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping("/gluten-free")
    public ResponseEntity<List<Recipe>> getGlutenFreeRecipes(){
        return new ResponseEntity<>(this.recipeService.getGlutenFreeRecipes(), HttpStatus.OK);
    }

    @GetMapping("/vegan")
    public ResponseEntity<List<Recipe>> getVeganRecipes(){
        return new ResponseEntity<>(this.recipeService.getVeganRecipes(), HttpStatus.OK);

    }

    @GetMapping("/vegan-and-gluten-free")
    public ResponseEntity<List<Recipe>> getVeganAndGlutenFreeRecipes(){
        return new ResponseEntity<>(this.recipeService.getVeganAndGlutenFreeRecipes(), HttpStatus.OK);

    }

    @GetMapping("/vegetarian")
    public ResponseEntity<List<Recipe>> getVegetarianRecipes(){
        return new ResponseEntity<>(this.recipeService.getVegetarianRecipes(), HttpStatus.OK);

    }

    @GetMapping("/all-recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes(){

        return new ResponseEntity<>(this.recipeService.getAllRecipes(), HttpStatus.OK);
    }
}

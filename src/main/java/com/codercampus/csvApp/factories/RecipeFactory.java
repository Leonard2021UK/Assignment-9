package com.codercampus.csvApp.factories;

import com.codercampus.csvApp.domain.Recipe;
import com.codercampus.csvApp.intrfaces.Factory;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;


@Component
public class RecipeFactory implements Factory<Recipe> {

    public Recipe create(CSVRecord data){
        Recipe recipe = new Recipe();
        recipe.setCookingMinutes(Integer.parseInt(data.get(0)));
        recipe.setDairyFree(Boolean.parseBoolean(data.get(1)));
        recipe.setGlutenFree(Boolean.parseBoolean(data.get(2)));
        recipe.setInstructions(data.get(3));
        recipe.setPreparationMinutes(Double.parseDouble(data.get(4)));
        recipe.setPricePerServing(Double.parseDouble(data.get(5)));
        recipe.setReadyInMinutes(Integer.parseInt(data.get(6)));
        recipe.setServings(Integer.parseInt(data.get(7)));
        recipe.setSpoonacularScore(Double.parseDouble(data.get(8)));
        recipe.setTitle(data.get(9));
        recipe.setVegan(Boolean.parseBoolean(data.get(10)));
        recipe.setVegetarian(Boolean.parseBoolean(data.get(11)));

        return recipe;
    }

}

package com.example.ai_recipe_app_kotlin.data

import com.example.ai_recipe_app_kotlin.R
import com.example.ai_recipe_app_kotlin.model.Difficulty
import com.example.ai_recipe_app_kotlin.model.IngredientItem
import com.example.ai_recipe_app_kotlin.model.OnboardingItem
import com.example.ai_recipe_app_kotlin.model.QuickRecipeItem
import com.example.ai_recipe_app_kotlin.model.RecipeDetailIngredientItem
import com.example.ai_recipe_app_kotlin.model.RecipeMakingStepsItem
import com.example.ai_recipe_app_kotlin.model.SavedRecipeItem

object SimpleData {
    val onboardingList = listOf(
        OnboardingItem(
            title = "Welcome to AI Recipe",
            description = "Discover delicious recipes powered by AI.",
            image = R.drawable.onboarding_first
        ),
        OnboardingItem(
            title = "Easy Search",
            description = "Find recipes based on ingredients you already have.",
            image = R.drawable.onboarding_second,
        ),
        OnboardingItem(
            title = "Cook Like a Pro",
            description = "Get step-by-step instructions for every dish.",
            image = R.drawable.onboarding_third
        )
    )

    val ingredients = listOf(
        IngredientItem(
            id = "ingredient-first-item-id",
            title = "Flour",
            description = "All purpose flour",
            ingredientImage = "https://www.thespruceeats.com/thmb/J1_oUODgxQi9Gm6iccam2LNYPpQ=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-126372385-58950f353df78caebc239b4d.jpg"
        ),
        IngredientItem(
            id = "ingredient-second-item-id",
            title = "Onion",
            description = "Red onion",
            ingredientImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxNCVwAjM6p7NJKuHirmaGkgEB9Q1aQp4a2Q&s"
        ),
        IngredientItem(
            id = "ingredient-third-item-id",
            title = "Milk",
            description = "Whole milk",
            ingredientImage = "https://img.magnific.com/free-photo/pitcher-with-some-milk_93675-128649.jpg?semt=ais_hybrid&w=740&q=80"
        ),
        IngredientItem(
            id = "ingredient-fourth-item-id",
            title = "Tomato",
            description = "Fresh tomato",
            ingredientImage = "https://png.pngtree.com/png-clipart/20230129/original/pngtree-red-fresh-tomato-with-green-leaf-png-image_8933861.png"
        )
    )

    val savedRecipes = listOf(
        SavedRecipeItem(
            id = "saved-recipe-first-item-id",
            title = "Spaghetti Bolognese",
            recipeImage = "https://png.pngtree.com/png-clipart/20230129/original/pngtree-red-fresh-tomato-with-green-leaf-png-image_8933861.png",
            recipeDuration = "30 min",
            difficulty = Difficulty.Medium,
            numberOfIngredientsUsed = 5,

        ),
        SavedRecipeItem(
            id = "saved-recipe-second-item-id",
            title = "Chicken Curry",
            recipeImage = "https://www.whiskaffair.com/wp-content/uploads/2021/10/Andhra-Chicken-Curry-2-3.jpg",
            recipeDuration = "45 min",
            difficulty = Difficulty.Hard,
            numberOfIngredientsUsed = 6
        ),
        SavedRecipeItem(
            id = "saved-recipe-third-item-id",
            title = "Vegetable Stir-Fry",
            recipeImage = "https://ohsweetbasil.com/wp-content/uploads/the-best-easy-stir-fry-vegetables-recipe-6.jpg",
            recipeDuration = "25 min",
            difficulty = Difficulty.Easy,
            numberOfIngredientsUsed = 4
        ),
        SavedRecipeItem(
            id = "saved-recipe-fourth-item-id",
            title = "Spicy Mutton Curry Recipe",
            recipeImage = "https://d3s8tbcesxr4jm.cloudfront.net/recipe-images/v0/spicy-mutton-curry_large.jpg",
            recipeDuration = "60 min",
            difficulty = Difficulty.Medium,
            numberOfIngredientsUsed = 7
        )
    )

    val quickIdeas = listOf(
        QuickRecipeItem(
            id = "quick-recipe-first-item-id",
            recipeImage = "https://vismaifood.com/storage/app/uploads/public/8b4/19e/427/thumb__1200_0_0_0_auto.jpg",
            title = "Masala dosa",
            recipeDuration = "30 min",
            difficulty = Difficulty.Easy,
            isFavorite = false
        ),
        QuickRecipeItem(
            id = "quick-recipe-second-item-id",
            recipeImage = "https://www.maggi.in/sites/default/files/srh_recipes/26de2f669c90f0fcc1a363cbd0b763e6.jpg",
            title = "Chicken Roll",
            recipeDuration = "20 min",
            difficulty = Difficulty.Hard,
            isFavorite = true
        ),
        QuickRecipeItem(
            id = "quick-recipe-third-item-id",
            recipeImage = "https://www.spicebangla.com/wp-content/uploads/2024/08/Egg-Masala-Curry.webp",
            title = "Egg curry",
            recipeDuration = "40 min",
            difficulty = Difficulty.Medium,
            isFavorite = false
        ),
        QuickRecipeItem(
            id = "quick-recipe-fourth-item-id",
            recipeImage = "https://images.food52.com/VOfOuvcQe7fBeSqixNe1L-LhUBY=/d815e816-4664-472e-990b-d880be41499f--chicken-biryani-recipe.jpg",
            title = "Chicken biryani",
            recipeDuration = "60 min",
            difficulty = Difficulty.Hard,
            isFavorite = true
        )
    )

    val recipeDetailIngredients = listOf(
        RecipeDetailIngredientItem(
            title = "Flour",
            quantity = "200g"
        ),
        RecipeDetailIngredientItem(
            title = "Onion",
            quantity = "1kg"
        ),
        RecipeDetailIngredientItem(
            title = "Milk",
            quantity = "1L"
        ),
        RecipeDetailIngredientItem(
            title = "Tomato",
            quantity = "1kg"
        ),
        RecipeDetailIngredientItem(
            title = "Salt",
            quantity = "1 tsp"
        ),
        RecipeDetailIngredientItem(
            title = "Pepper",
            quantity = "1 tsp"
        ),
        RecipeDetailIngredientItem(
            title = "Garlic",
            quantity = "1 tsp"
        ),
        RecipeDetailIngredientItem(
            title = "Sugar",
            quantity = "1 tsp"
        ),
        RecipeDetailIngredientItem(
            title = "Butter",
            quantity = "100g"
        ),
    )

    val recipeMakingSteps = listOf(
        RecipeMakingStepsItem(
            step = "Step 1",
            stepDescription = "Preheat the oven to 180°C (350°F)."
        ),
        RecipeMakingStepsItem(
            step = "Step 2",
            stepDescription = "Mix the flour, sugar, baking powder, and salt in a large bowl."
        ),
        RecipeMakingStepsItem(
            step = "Step 3",
            stepDescription = "Bake for 25-30 minutes or until a toothpick inserted into the center of the dough comes out clean."
        ),
        RecipeMakingStepsItem(
            step = "Step 4",
            stepDescription = "Let the cake cool in the oven for a few minutes before removing it from the pan."
        ),
        RecipeMakingStepsItem(
            step = "Step 5",
            stepDescription = "Serve the cake immediately."
        ),
        RecipeMakingStepsItem(
            step = "Step 6",
            stepDescription = "Enjoy!"
        )
    )
}
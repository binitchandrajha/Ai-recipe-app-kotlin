package com.example.ai_recipe_app_kotlin.data

import com.example.ai_recipe_app_kotlin.R
import com.example.ai_recipe_app_kotlin.model.Difficulty
import com.example.ai_recipe_app_kotlin.model.IngredientItem
import com.example.ai_recipe_app_kotlin.model.OnboardingItem
import com.example.ai_recipe_app_kotlin.model.QuickRecipeItem
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
            title = "Flour",
            description = "All purpose flour",
            ingredientImage = "https://www.thespruceeats.com/thmb/J1_oUODgxQi9Gm6iccam2LNYPpQ=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-126372385-58950f353df78caebc239b4d.jpg"
        ),
        IngredientItem(
            title = "Onion",
            description = "Red onion",
            ingredientImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxNCVwAjM6p7NJKuHirmaGkgEB9Q1aQp4a2Q&s"
        ),
        IngredientItem(
            title = "Milk",
            description = "Whole milk",
            ingredientImage = "https://img.magnific.com/free-photo/pitcher-with-some-milk_93675-128649.jpg?semt=ais_hybrid&w=740&q=80"
        ),
        IngredientItem(
            title = "Tomato",
            description = "Fresh tomato",
            ingredientImage = "https://png.pngtree.com/png-clipart/20230129/original/pngtree-red-fresh-tomato-with-green-leaf-png-image_8933861.png"
        )
    )

    val savedRecipes = listOf(
        SavedRecipeItem(
            title = "Spaghetti Bolognese",
            recipeImage = "https://png.pngtree.com/png-clipart/20230129/original/pngtree-red-fresh-tomato-with-green-leaf-png-image_8933861.png",
            recipeDuration = "30 min",
            difficulty = Difficulty.Medium,
            numberOfIngredientsUsed = 5,

        ),
        SavedRecipeItem(
            title = "Chicken Curry",
            recipeImage = "https://www.whiskaffair.com/wp-content/uploads/2021/10/Andhra-Chicken-Curry-2-3.jpg",
            recipeDuration = "45 min",
            difficulty = Difficulty.Hard,
            numberOfIngredientsUsed = 6
        ),
        SavedRecipeItem(
            title = "Vegetable Stir-Fry",
            recipeImage = "https://ohsweetbasil.com/wp-content/uploads/the-best-easy-stir-fry-vegetables-recipe-6.jpg",
            recipeDuration = "25 min",
            difficulty = Difficulty.Easy,
            numberOfIngredientsUsed = 4
        ),
        SavedRecipeItem(
            title = "Spicy Mutton Curry Recipe",
            recipeImage = "https://d3s8tbcesxr4jm.cloudfront.net/recipe-images/v0/spicy-mutton-curry_large.jpg",
            recipeDuration = "60 min",
            difficulty = Difficulty.Medium,
            numberOfIngredientsUsed = 7
        )
    )

    val quickIdeas = listOf(
        QuickRecipeItem(
            recipeImage = "https://vismaifood.com/storage/app/uploads/public/8b4/19e/427/thumb__1200_0_0_0_auto.jpg",
            title = "Masala dosa",
            recipeDuration = "30 min",
            difficulty = Difficulty.Easy,
            isFavorite = false
        ),
        QuickRecipeItem(
            recipeImage = "https://www.maggi.in/sites/default/files/srh_recipes/26de2f669c90f0fcc1a363cbd0b763e6.jpg",
            title = "Chicken Roll",
            recipeDuration = "20 min",
            difficulty = Difficulty.Hard,
            isFavorite = true
        ),
        QuickRecipeItem(
            recipeImage = "https://www.spicebangla.com/wp-content/uploads/2024/08/Egg-Masala-Curry.webp",
            title = "Egg curry",
            recipeDuration = "40 min",
            difficulty = Difficulty.Medium,
            isFavorite = false
        ),
        QuickRecipeItem(
            recipeImage = "https://images.food52.com/VOfOuvcQe7fBeSqixNe1L-LhUBY=/d815e816-4664-472e-990b-d880be41499f--chicken-biryani-recipe.jpg",
            title = "Chicken biryani",
            recipeDuration = "60 min",
            difficulty = Difficulty.Hard,
            isFavorite = true
        )
    )
}
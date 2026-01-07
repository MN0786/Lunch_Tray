package com.example.lunchtray.data

import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.SideDishMenu
import com.example.lunchtray.model.MenuItem.EntreeMenu
import com.example.lunchtray.model.MenuItem.Accompaniment

object DataSource {
    val entreeMenuItem = listOf(
        EntreeMenu(
            "Cauliflower",
            "Whole cauliflower, brined, roasted, and deep fried",
            7.00

        ),
        EntreeMenu(
            "Three Bean Chili",
            "Black beans, red beans, kidney beans, slow cooked, topped with onion",
            4.00,
        ),
        EntreeMenu(
            "Mushroom Pasta",
            "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic " +
                    "and olive oil",
            5.50,
        ),
        EntreeMenu(
            "Spicy Black Bean Skillet",
            "Seasonal vegetables, black beans, house spice blend, served with " +
                    "avocado and quick pickled onions",
            5.50,
        )


        )
    val sideDishMenuItem = listOf(

        SideDishMenu(
            "Summer Salad",
            "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic dressing",
            2.50,
        ),
        SideDishMenu(

            "Butternut Squash Soup",
            "Roasted butternut squash, roasted peppers, chili oil",
            3.00,

        ),
        SideDishMenu(

            "Spicy Potatoes",
            "Marble potatoes, roasted, and fried in house spice blend",
            2.00,

        ),
        SideDishMenu(

            "Coconut Rice",
            "Rice, coconut milk, lime, and sugar",
            1.50,

        )

    )
    val accompanimentMenuItem = listOf(


        Accompaniment(
            "Lunch Roll",
            "Fresh baked roll made in house",
            0.50,
        ),
        Accompaniment(
            "Mixed Berries",
            "Strawberries, blueberries, raspberries, and huckleberries",
            1.00,
        ),
        Accompaniment(
            "Pickled Veggies",
            "Pickled cucumbers and carrots, made in house",
            0.50,
        )
    )



}
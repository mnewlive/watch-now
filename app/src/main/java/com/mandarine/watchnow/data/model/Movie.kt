package com.mandarine.watchnow.data.model

data class Movie(
    val id: Int,
    val image: String,
    val actors: List<Actor>,
    val storyline: String
)

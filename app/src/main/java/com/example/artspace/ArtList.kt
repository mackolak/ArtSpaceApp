package com.example.artspace

data class ArtList(val artId: Int, val artTitleId: Int, val artAuthorAndYear: Int) {
    companion object {
        fun getArtList(): List<ArtList> {
            return listOf(
                ArtList(
                    R.drawable.hellebore,
                    R.string.hellebore_title,
                    R.string.hellebore_author_and_year
                ),
                ArtList(
                    R.drawable.trees,
                    R.string.trees_title,
                    R.string.trees_author_and_year
                ),
                ArtList(
                    R.drawable.yellow_flowers,
                    R.string.yellow_flowers_title,
                    R.string.yellow_flowers_author_and_year
                ),
            )
        }
    }
}
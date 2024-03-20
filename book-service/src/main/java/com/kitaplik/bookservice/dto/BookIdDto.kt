package com.kitaplik.bookservice.dto

data class BookIdDto @JvmOverloads constructor(
        val bookId: String? = "",
        val isbn: String
) {
    //Dto converter a alternatif yöntem
    companion object {
        @JvmStatic
        fun convert(id: String, isbn: String): BookIdDto {
            return BookIdDto(id, isbn)
        }
    }
}
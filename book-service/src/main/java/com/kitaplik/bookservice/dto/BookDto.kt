package com.kitaplik.bookservice.dto

import com.kitaplik.bookservice.model.Book

/* @JvmOverloads: kotlin reflectiondan gelir.
* Constructoru oluşturunca bu sınıfa ait birden fazla constructor sunmuş olur
* nullable alanların olup ve olmadığı alanlar için @NoArgsConstructor ve
* AllArgsConstructor alternatifi gibi*/

data class BookDto @JvmOverloads constructor(
        val id: BookIdDto? = null,
        val title: String,
        val bookYear: Int,
        val author: String,
        val pressName: String
) {
    companion object {
        @JvmStatic
        fun  convert(from: Book): BookDto{
            return BookDto(
                from.id?.let {BookIdDto.convert(it, from.isbn) },
                from.title,
                from.bookYear,
                from.author,
                from.pressName

            )
        }
    }
}

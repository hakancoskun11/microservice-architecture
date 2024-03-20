package com.kitaplik.libraryservice.dto

//@JvmOverloads ile bu alanlar null olabilir, null verilirse construcotrda default değerini alttakiler olsun
data class LibraryDto @JvmOverloads constructor(
        val id: String? = "",
        val userBookList: List<BookDto>? = ArrayList()
) {

}
package com.example.mentorify.Utils

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorify.Adapter.KategoriSearchPage
import com.example.mentorify.Adapter.PopulerSearchPage
import com.example.mentorify.Models.SearchPageKategoriModel
import com.example.mentorify.Models.SearchPagePopularModel
import com.example.mentorify.R

class SearchPageSection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_page_section)

        val list_populer = findViewById<RecyclerView>(R.id.list_kategori_populer_searchpage)
        list_populer.adapter = PopulerSearchItems

        val list_kategori = findViewById<RecyclerView>(R.id.list_kategori_searchpage)
        list_kategori.adapter = KategoriSearchItems

        val backBtn = findViewById<ImageView>(R.id.back_btn_searchpage)
        backBtn.setOnClickListener {
            Toast.makeText(this@SearchPageSection, "test!", Toast.LENGTH_LONG).show()
        }

    }

    private val PopulerSearchItems by lazy {

        val items = listOf<SearchPagePopularModel>(
            SearchPagePopularModel("Coding"),
            SearchPagePopularModel("UI/UX"),
            SearchPagePopularModel("Java"),
            SearchPagePopularModel("Bisnis"),
            SearchPagePopularModel("Digital Marketing"),
            SearchPagePopularModel("AR"),
            SearchPagePopularModel("Coding"),
        )

        PopulerSearchPage(items, object : PopulerSearchPage.AdapterListener{
            override fun onClick(items : SearchPagePopularModel) {
                Toast.makeText(this@SearchPageSection, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }

    private val KategoriSearchItems by lazy {

        val items = listOf<SearchPageKategoriModel>(
            SearchPageKategoriModel(R.drawable.coding, "Coding", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.teknik_industri, "Teknik Industri", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.data_science, "Data Science", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.marketing, "Digital Marketing", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.management, "Manajemen", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.sistem_informasi, "Sistem Informasi", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.design, "Desain", R.drawable.arrow)
        )

        KategoriSearchPage(items, object : KategoriSearchPage.AdapterListener{
            override fun onClick(items : SearchPageKategoriModel) {
                Toast.makeText(this@SearchPageSection, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }


}
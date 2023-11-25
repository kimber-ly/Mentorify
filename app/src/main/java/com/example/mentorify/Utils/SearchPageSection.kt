package com.example.mentorify.Utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
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
            SearchPagePopularModel("Programming"),
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
            SearchPageKategoriModel(R.drawable.icon_coding, "Programming", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.icon_teknikindustri, "Teknik Industri", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.icon_datascience, "Data Sciense", R.drawable.arrow),
            SearchPageKategoriModel(R.drawable.icon_marketing, "Digiral Marketing", R.drawable.arrow),
        )

        KategoriSearchPage(items, object : KategoriSearchPage.AdapterListener{
            override fun onClick(items : SearchPageKategoriModel) {
                Toast.makeText(this@SearchPageSection, "test!", Toast.LENGTH_LONG).show()
            }
        })


    }


}
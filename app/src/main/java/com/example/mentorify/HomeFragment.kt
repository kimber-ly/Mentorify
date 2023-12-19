package com.example.mentorify

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mentorify.Adapter.MentorCardAdapter
import com.example.mentorify.Adapter.PopularKategoriAdapter
import com.example.mentorify.Models.DataUser
import com.example.mentorify.Models.GetProfileModel
import com.example.mentorify.Models.MentorCardModel
import com.example.mentorify.Models.PopularKategoryModel
import com.example.mentorify.Utils.SearchPageSection
import com.example.mentorify.api.ApiInterface
import com.example.mentorify.api.RetrofitInstance
import com.example.mentorify.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PopularKategoriAdapter//define adapter

    private var pop_mentor_list = ArrayList<PopularKategoryModel>()//define popular list


    //>>>>>>>>>> onCreate method >>>>>>>>>>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //search init
        binding.searchBarHome.queryHint = "Cari Mentor"
        binding.searchBarHome.setIconifiedByDefault(false)

//        val adapter = PopularKategoriAdapter(popularMentorData())
//        binding.popularKategoriContent.adapter = adapter


        //fix size popular recyclerView
        binding.popularKategoriContent.setHasFixedSize(true)
        //layout Manager popular list
        binding.popularKategoriContent.
        layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        //data added to popular list
        addDataToList()
        //set adapter for popular list
        this.adapter = PopularKategoriAdapter(pop_mentor_list)
        //set "popular recyclerView" with specified adapter
        binding.popularKategoriContent.adapter = this.adapter



        binding.topMatchesRecycler.adapter = Mentor
        binding.topMatchesRecycler.layoutManager = GridLayoutManager(requireContext(), 2)


        //<<<<<<<<<< search query <<<<<<<<<<
        binding.searchBarHome.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })//<<<<<<<<<< end search query <<<<<<<<<<

        return binding.root
    } //<<<<<<<<<< end onCreate method <<<<<<<<<<

    private fun fetchData() {
        val retrofit = RetrofitInstance.getRetrofitInstance()
        val apiService = retrofit.create(ApiInterface::class.java)

        val call = apiService.getProfile()

        call.enqueue(object : Callback<GetProfileModel?> {
            override fun onResponse(
                call: Call<GetProfileModel?>,
                response: Response<GetProfileModel?>
            ) {
                if (response.isSuccessful) {
                    val profileModel = response.body()
                    val fullName = profileModel?.user?.fullName
                    if (fullName != null) {
                        Log.d("HomeFragment", "FullName from API: $fullName")
                        binding.userFullName.text = fullName
                        Log.d("HomeFragment", "FullName set to TextView: ${binding.userFullName.text}")
                    } else {
                        Log.d("HomeFragment", "No luck")
                    }

                    // Log the entire response body
                    Log.d("HomeFragment", "Response Body: ${response.body()}")
                } else {
                    Log.d("$this@HomeFragment", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<GetProfileModel?>, t: Throwable) {
                Log.d("$this@HomeFragment", "${t.message}")
            }
        })
    }

    //>>>>>>>>>> filtering method for search >>>>>>>>>>
    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<PopularKategoryModel>()
            for (i in pop_mentor_list) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(binding.root.context, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            } else {
                this.adapter.setFilteredList(filteredList)
            }
        }
    } //<<<<<<<<<< end filtering method <<<<<<<<<


    private fun addDataToList(){
        for(user in DataUser.getAllData()){
            pop_mentor_list.add(PopularKategoryModel(
                image = user.get("image") as Int,
                name = user.get("name") as String,
                occasion = user.get("occasion") as String,
                price = user.get("price") as String,
                rating = user.get("rating") as String,
                session = user.get("session") as String
            ))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        fetchData()

//        val btnsiti: Button = binding.btnSelengkapnyasiti
//        btnsiti.setOnClickListener(this)

        val btndzik: TextView = binding.btnSeeallPopular
        btndzik.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
//        if (v?.id == R.id.btn_selengkapnyasiti){
//            val int = Intent(activity, OverviewActivity::class.java)
//            startActivity(int)
//        }
        if (v?.id == R.id.btn_seeall_popular){
            val int = Intent(activity, SearchPageSection::class.java)
            startActivity(int)
        }
    }

    private val Mentor by lazy {

        val items = listOf<MentorCardModel>(
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(
                R.drawable.card_orang6,
                "Sambas Purnama Endang",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.card_orang4,
                "Faza Atsmaro H. S",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.carddzikri,
                "Dzikri Arfiansyah",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(
                R.drawable.card_orang6,
                "Sambas Purnama Endang",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.card_orang4,
                "Faza Atsmaro H.S",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.carddzikri,
                "Dzikri Arfiansyah",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(R.drawable.card_orang5, "Al Ikhsan Akbar", "Mentor Coding", "Rp50.000"),
            MentorCardModel(R.drawable.card_orang7, "Putri Alifia", "Mentor Coding", "Rp50.000"),
            MentorCardModel(
                R.drawable.card_orang6,
                "Sambas Purnama Endang",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(
                R.drawable.card_orang4,
                "Faza Atsmaro H.S",
                "Mentor Coding",
                "Rp50.000"
            ),
            MentorCardModel(R.drawable.carddzikri, "Dzikri Arfiansyah", "Mentor Coding", "Rp50.000")

        )

        MentorCardAdapter(items, object : MentorCardAdapter.AdapterListener {
            override fun onClick(mentor: MentorCardModel) {
//                Toast.makeText(requireContext(), "test!", Toast.LENGTH_LONG).show()
//                val intent = Intent(requireContext(), OverviewActivity::class.java)
//                startActivity(intent)
            }
        })
    }
}
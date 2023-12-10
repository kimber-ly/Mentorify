package com.example.mentorify.Models

class DataWhislist {
    companion object{

        private var wishlists : ArrayList<String> = ArrayList()

        fun getAllData():ArrayList<String>{
            return wishlists
        }
        fun addWishlist(wishlist : String){
            wishlists.add(wishlist)
        }

        fun delWishlist(name : String){
            wishlists.remove(name)
        }
    }

}

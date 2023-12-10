package com.example.mentorify.Models

class DataUser {
    companion object{

        private var users : ArrayList<Map<String, Any>> = ArrayList()

        fun getAllData():ArrayList<Map<String, Any>>{
            return users
        }
        fun addUser(user : Map<String, Any>){
            users.add(user)
        }
    }

}

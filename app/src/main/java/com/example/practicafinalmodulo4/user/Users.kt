package com.example.practicafinalmodulo4.user

class Users {
    private val usersList: MutableList<User> = mutableListOf()


    fun addUser(user: User) {
        usersList.add(user)
    }

    fun getUser(): List<User> {
        return usersList
    }

}
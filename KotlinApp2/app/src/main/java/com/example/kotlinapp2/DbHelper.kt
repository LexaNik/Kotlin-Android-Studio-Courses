package com.example.kotlinapp2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE Table users (id INT PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS USers")
        onCreate(db)
    }

    fun addUser(user: User) {
        val value = ContentValues()
        value.put("login", user.login)
        value.put("email", user.email)
        value.put("password", user.pass)

        val db = this.writableDatabase

        db.insert("Users", null, value)
        db.close()
    }
}
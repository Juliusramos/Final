package com.firstapp.loginactivity

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "UserDatabase.db"
        private const val DATABASE_VERSION = 2
        private const val TABLE_NAME = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = ("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_EMAIL TEXT UNIQUE, " +
                "$COLUMN_PASSWORD TEXT)")
        db?.execSQL(createTableQuery)
        Log.d("DatabaseHelper", "✅ Users table created successfully")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(name: String, email: String, password: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_EMAIL, email)
            put(COLUMN_PASSWORD, password)
        }
        val result = db.insert(TABLE_NAME, null, values)
        db.close()
        return result
    }

    fun readUser(email: String, password: String): Boolean {
        val db = readableDatabase
        val selection = "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        val selectionArgs = arrayOf(email, password)
        val cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null)

        val userExists = cursor.count > 0
        cursor.close()
        db.close()
        return userExists
    }

    fun isUserExists(email: String): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_EMAIL = ?", arrayOf(email))
        val exists = cursor.count > 0
        cursor.close()
        db.close()
        return exists
    }
}

package com.shayaan.passwordgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import kotlin.String

class MainScreen : AppCompatActivity() {
    private lateinit var keyword:EditText
    private lateinit var listView:ListView
    private val passwords : MutableList<String> = mutableListOf()
    private lateinit var adapter : ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        this.listView = findViewById(R.id.passwordList)
        this.keyword = findViewById(R.id.inputText)
        this.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, passwords)
        this.listView.adapter = this.adapter
    }
    fun generatePassword(view:View){
        val keywordString: String = keyword.text.toString()
        var x = 0
        while(x < 10){
            passwords.add(this.getRandomString(keywordString.length + 5, keywordString[0].toUpperCase() + keywordString.substring(1)))
            x++
        }
        adapter.notifyDataSetChanged()
    }
    fun clear(view: View){
        passwords.clear()
        adapter.notifyDataSetChanged()
    }
    private fun getRandomString(length : Int, key : String) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9') + "." + "_" + "!" + "&"
        return key + (1..length).map { allowedChars.random() }.joinToString("")
    }
}
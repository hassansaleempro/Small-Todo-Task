package com.example.dnamicrotest.addTodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dnamicrotest.ListingActivity
import com.example.dnamicrotest.R
import com.example.dnamicrotest.TinyDb.TinyDB
import com.example.dnamicrotest.adapter.myAdapter
import com.example.dnamicrotest.searchTodo.SearchTodoActivity

class AddTodoActivity : AppCompatActivity() {
    private lateinit var backBtn: ImageView
    private lateinit var addBtn: TextView
    private lateinit var addET: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)
        initViews()
        initListners()
    }

    private fun initListners() {
        backBtn.setOnClickListener {
            finish()
        }

        addBtn.setOnClickListener {

            var temp = TinyDB(this).getListString(getString(R.string.todoList))
            temp.add(addET.text.toString())
            TinyDB(this).putListString(getString(R.string.todoList),temp)

            addET.text.clear()

            Toast.makeText(this, "Todo Added", Toast.LENGTH_SHORT).show()

        }
    }

    private fun initViews() {
        backBtn = findViewById(R.id.add_back_btn)
        addBtn = findViewById(R.id.add_btn)
        addET = findViewById(R.id.add_et)
    }
}
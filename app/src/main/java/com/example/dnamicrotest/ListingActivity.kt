package com.example.dnamicrotest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dnamicrotest.TinyDb.TinyDB
import com.example.dnamicrotest.adapter.myAdapter
import com.example.dnamicrotest.addTodo.AddTodoActivity
import com.example.dnamicrotest.searchTodo.SearchTodoActivity

class ListingActivity : AppCompatActivity() {
    private lateinit var todoListView : RecyclerView
    private lateinit var searchBtn : ImageView
    private lateinit var addBtn : ImageView
    private var todoList : ArrayList<String> = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)

        initViews()
        initListners()
    }

    private fun initListners() {
        searchBtn.setOnClickListener {
            startActivity(Intent(this,SearchTodoActivity::class.java))
        }

        addBtn.setOnClickListener {
            startActivity(Intent(this,AddTodoActivity::class.java))
        }
    }


    override fun onResume() {
        super.onResume()

        var temp = TinyDB(this).getListString(getString(R.string.todoList))

        if(temp != null && temp.size > 0 ){
            temp.map {
                todoList.add(it)
            }
        }

        Log.wtf("Hassan","$todoList")

        todoListView.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            setHasFixedSize(true)
            adapter = myAdapter(todoList)
        }

    }
    private fun initViews() {
        todoListView = findViewById(R.id.listing)
        searchBtn = findViewById(R.id.search)
        addBtn = findViewById(R.id.add)

    }
}
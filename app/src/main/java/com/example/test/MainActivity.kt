package com.example.test

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), Adapter.onClickEditText {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter
    var editTextStr: String? =null
    var count = 0
    var modelIndex = 0
    lateinit var plusBtn : ImageView
    lateinit var modelList: ArrayList<Model>
    lateinit var btnContinue : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_pet_name)
        plusBtn = findViewById(R.id.plus)
        btnContinue = findViewById(R.id.btn_continue)

        modelList = ArrayList()

        modelList.add(modelIndex,Model(modelIndex,""))

        adapter = Adapter(modelList,this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        plusBtn.setOnClickListener {
            modelIndex++
            modelList.add(modelIndex,Model(modelIndex,editTextStr!!))
            adapter = Adapter(modelList,this)

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }

        btnContinue.setOnClickListener {
            Log.d("CheckList", "onCreate: $modelList and list size is => ${modelList.size} ")
        }

    }

    override fun editTextClicked(text: String) {
        editTextStr = text
    }
}
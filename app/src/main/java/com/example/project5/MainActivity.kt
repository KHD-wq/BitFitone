package com.example.project5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private val itemList = mutableListOf<HealthMetrics>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        itemAdapter = ItemAdapter(itemList)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val heightInput: EditText = findViewById(R.id.heightInput)
        val weightInput: EditText = findViewById(R.id.weightInput)
        val addButton: Button = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val itemHeight = heightInput.text.toString()
            val itemWeight = weightInput.text.toString()
            if (itemHeight.isNotEmpty() && itemWeight.isNotEmpty()) {
                itemList.add(HealthMetrics(itemHeight, itemWeight))
                itemAdapter.notifyDataSetChanged()
                heightInput.text.clear()
                weightInput.text.clear()
            }
        }
    }
}
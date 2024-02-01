package com.example.hw_3_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_3_6.databinding.ActivityMainBinding

private var ConstraintLayout.layoutManager: GridLayoutManager
    get() {}
    set() {}

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private  val adapter =PlantAdapter()
    private val imageIdList = listOf(R.drawable.title_1,R.drawable.title_4,R.drawable.title_5,
            R.drawable.title_6, R.drawable.title_8)

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private  fun init()  {
        binding.apply {
         rcView.layoutManager =  GridLayoutManager(this@MainActivity, 3)
            val adapter = adapter
            buttonAdd.setOnClickListener{
                if (index > 4) index = 0
                val plant = Plant(imageIdList[index],"Plant $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }

}
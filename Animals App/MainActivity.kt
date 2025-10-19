package com.example.tp05
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimalAdapter
    private lateinit var rbLinear: RadioButton
    private lateinit var rbGrid: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewAnimals)
        rbLinear = findViewById(R.id.rbLinear)
        rbGrid = findViewById(R.id.rbGrid)

        val animals = mutableListOf(
            Animal("Chat", "Mammifère", R.drawable.cat),
            Animal("Chien", "Mammifère", R.drawable.dog),
            Animal("Perroquet", "Oiseau", R.drawable.parrot),
            Animal("Tortue", "Reptile", R.drawable.turtle),
            Animal("Lion", "Mammifère", R.drawable.lion),
            Animal("Serpent", "Reptile", R.drawable.snake)
        )

        adapter = AnimalAdapter(
            animals,
            onDetailsClick = { animal ->
                Toast.makeText(this, "${animal.name} (${animal.species})", Toast.LENGTH_SHORT).show()
            },
            onDeleteClick = { animal ->
                Toast.makeText(this, "${animal.name} supprimé", Toast.LENGTH_SHORT).show()
            }
        )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        rbLinear.setOnClickListener {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        rbGrid.setOnClickListener {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
    }
}

package com.example.tp05

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(
    private val animals: MutableList<Animal>,
    private val onDetailsClick: (Animal) -> Unit,
    private val onDeleteClick: (Animal) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgAnimal: ImageView = view.findViewById(R.id.imgAnimal)
        val txtName: TextView = view.findViewById(R.id.txtName)
        val txtSpecies: TextView = view.findViewById(R.id.txtSpecies)
        val btnDetails: Button = view.findViewById(R.id.btnDetails)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animal_item, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]
        holder.imgAnimal.setImageResource(animal.imageResId)
        holder.txtName.text = animal.name
        holder.txtSpecies.text = animal.species

        holder.btnDetails.setOnClickListener { onDetailsClick(animal) }
        holder.btnDelete.setOnClickListener {
            onDeleteClick(animal)
            animals.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}

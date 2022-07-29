package ru.unlucky.students.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.unlucky.students.data.Student
import ru.unlucky.students.ui.main.holder.StudentHolder
import ru.unlucky.students.utils.replaceWith

class StudentListAdapter(private val onItemClick: (Int) -> Unit): RecyclerView.Adapter<StudentHolder>() {

    private val items = mutableListOf<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            StudentHolder.create(parent, onItemClick)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<Student>) {
        this.items.replaceWith(items)
        notifyDataSetChanged()
    }
}
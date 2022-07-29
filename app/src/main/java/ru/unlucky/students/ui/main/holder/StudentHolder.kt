package ru.unlucky.students.ui.main.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.unlucky.students.data.Student
import ru.unlucky.students.databinding.ItemStudentBinding

class StudentHolder private constructor(private val binding: ItemStudentBinding,
                                        private val onItemClick: (Int) -> Unit): RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup, onItemClick: (Int) -> Unit): StudentHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemStudentBinding.inflate(layoutInflater, parent, false)
            return StudentHolder(binding, onItemClick)
        }
    }

    init {
        itemView.setOnClickListener { onItemClick.invoke(bindingAdapterPosition) }
    }

    fun bind(item: Student) {
        binding.nameTextView.text = item.name
        binding.courseTextView.text = item.course
    }

}
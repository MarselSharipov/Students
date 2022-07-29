package ru.unlucky.students.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.get
import ru.unlucky.students.data.Student
import ru.unlucky.students.databinding.ActivityMainBinding
import ru.unlucky.students.ui.about.AboutActivity
import ru.unlucky.students.ui.main.adapter.StudentListAdapter

class MainActivity: MvpAppCompatActivity(), IMainActivity {

    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { get<MainPresenter>() }

    private lateinit var adapter: StudentListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        adapter = StudentListAdapter(presenter::processStudentClick)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    override fun showStudentList(studentList: List<Student>) {
        adapter.setItems(studentList)
    }

    override fun openAboutStudent(student: Student) {
        startActivity(AboutActivity.makeIntent(this, student))
    }

}
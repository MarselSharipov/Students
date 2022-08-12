package ru.unlucky.students.ui.main

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.get
import ru.unlucky.students.R
import ru.unlucky.students.data.Student
import ru.unlucky.students.databinding.ActivityMainBinding
import ru.unlucky.students.databinding.DialogAddBinding
import ru.unlucky.students.ui.about.AboutActivity
import ru.unlucky.students.ui.add.AddActivity
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
        adapter = StudentListAdapter(presenter::processStudentItemClick, presenter::processDeleteClick)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        binding.fab.setOnClickListener { presenter.processFabClick() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                R.id.item_add -> {
                    presenter.processAddClick()
                    true
                }
                R.id.item_sort_by_surname -> {
                    presenter.processSortBySurnameClick()
                    true
                }
                R.id.item_sort_by_course -> {
                    presenter.processSortByCourseClick()
                    true
                }
                R.id.item_sort_by_year -> {
                    presenter.processSortByYearClick()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun showStudentList(studentList: List<Student>) {
        adapter.setItems(studentList)
    }

    override fun showAddStudentDialog() {
        val dialog = AlertDialog.Builder(this)
                .setTitle(getString(R.string.add))
                .create()

        val dialogView = DialogAddBinding.inflate(layoutInflater)
        dialogView.cancelButton.setOnClickListener { dialog.dismiss() }
        dialogView.actionButton.setOnClickListener {
            presenter.processDialogActionClick(
                    dialogView.surnameEditText.text.toString(),
                    dialogView.courseEditText.text.toString(),
                    dialogView.yearEditText.text.toString()
            )
            dialog.dismiss()
        }

        dialog.setView(dialogView.root)
        dialog.show()
    }

    override fun openAboutStudent(student: Student) {
        startActivity(AboutActivity.makeIntent(this, student))
    }

    override fun openAddStudent() {
        startActivity(AddActivity.makeIntent(this))
    }

}
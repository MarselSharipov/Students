package ru.unlucky.students.ui.main

import moxy.MvpPresenter
import ru.unlucky.students.data.Student
import ru.unlucky.students.utils.Utils

class MainPresenter(private val utils: Utils): MvpPresenter<IMainActivity>() {

    private lateinit var studentList: MutableList<Student>

    override fun attachView(view: IMainActivity?) {
        super.attachView(view)
        studentList = utils.getStudentsList()
        viewState.showStudentList(studentList)
    }

    fun processAddClick() {
        viewState.showAddStudentDialog()
    }

    fun processDialogActionClick(surname: String, course: String, year: String) {
        studentList.add(Student(surname, course, year))
        utils.saveList(studentList)
        viewState.showStudentList(studentList)
    }

    fun processFabClick() {
        viewState.openAddStudent()
    }

    fun processStudentItemClick(position: Int) {
        viewState.openAboutStudent(studentList[position])
    }

    fun processDeleteClick(position: Int) {
        studentList.removeAt(position)
        utils.saveList(studentList)
        viewState.showStudentList(studentList)
    }

}
package ru.unlucky.students.ui.about

import moxy.MvpPresenter
import ru.unlucky.students.data.Student
import ru.unlucky.students.utils.Utils

class AboutPresenter(private val utils: Utils): MvpPresenter<IAboutActivity>() {

    lateinit var student: Student

    override fun onFirstViewAttach() {
        viewState.setStudent(student)
    }

    fun processDeleteClick() {
        val list = utils.getStudentsList()
        list.remove(student)
        utils.saveList(list)
        viewState.close()
    }

}
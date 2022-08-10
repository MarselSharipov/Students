package ru.unlucky.students.ui.add

import moxy.MvpPresenter
import ru.unlucky.students.data.Student
import ru.unlucky.students.utils.Utils

class AddPresenter(private val utils: Utils): MvpPresenter<IAddActivity>() {

    private var surname = ""
    private var course = ""
    private var year = ""

    fun processSurnameChange(input: String) {
        surname = input
    }

    fun processCourseChange(input: String) {
        course = input
    }

    fun processYearChange(input: String) {
        year = input
    }

    fun processActionClick() {
        utils.addStudent(Student(surname, course, year))
        viewState.close()
    }

    fun processCancelClick() {
        viewState.close()
    }

}
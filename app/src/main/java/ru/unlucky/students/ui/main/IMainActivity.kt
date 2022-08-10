package ru.unlucky.students.ui.main

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution
import ru.unlucky.students.data.Student

interface IMainActivity: MvpView {

    fun showStudentList(studentList: List<Student>)

    @OneExecution
    fun showAddStudentDialog()

    @OneExecution
    fun openAboutStudent(student: Student)

    @OneExecution
    fun openAddStudent()

}
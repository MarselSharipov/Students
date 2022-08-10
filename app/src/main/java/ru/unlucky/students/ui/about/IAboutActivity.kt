package ru.unlucky.students.ui.about

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution
import ru.unlucky.students.data.Student

interface IAboutActivity: MvpView {

    fun setStudent(student: Student)

    @OneExecution
    fun close()

}
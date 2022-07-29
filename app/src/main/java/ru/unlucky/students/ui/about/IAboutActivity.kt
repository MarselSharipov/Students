package ru.unlucky.students.ui.about

import moxy.MvpView
import ru.unlucky.students.data.Student

interface IAboutActivity: MvpView {

    fun setStudent(student: Student)

}
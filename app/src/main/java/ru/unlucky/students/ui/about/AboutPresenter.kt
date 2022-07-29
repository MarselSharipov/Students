package ru.unlucky.students.ui.about

import moxy.MvpPresenter
import ru.unlucky.students.data.Student

class AboutPresenter: MvpPresenter<IAboutActivity>() {

    lateinit var student: Student

    override fun onFirstViewAttach() {
        viewState.setStudent(student)
    }

}
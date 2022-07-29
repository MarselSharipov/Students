package ru.unlucky.students.ui.main

import moxy.MvpPresenter
import ru.unlucky.students.data.Student
import ru.unlucky.students.utils.Utils

class MainPresenter(private val utils: Utils): MvpPresenter<IMainActivity>() {

    private lateinit var studentList: List<Student>

    private val students = listOf(
        Student("Смирнов", "1", "2000"),
        Student("Иванов", "1", "2000"),
        Student("Кузнецов", "1", "2000"),
        Student("Соколов", "1", "2000"),
        Student("Попов", "2", "1999"),
        Student("Лебедев", "3", "1998"),
        Student("Козлов", "2", "1999"),
        Student("Новиков", "3", "1998"),
        Student("Морозов", "4", "1997"),
        Student("Петров", "1", "2000"),
        Student("Волков", "2", "1998"),
        Student("Соловьёв", "2", "1998"),
        Student("Васильев", "1", "2000"),
        Student("Зайцев", "3", "1996"),
        Student("Павлов", "3", "1998"),
        Student("Семёнов", "4", "1998"),
        Student("Голубев", "2", "2000"),
        Student("Виноградов", "1", "2001"),
        Student("Богданов", "3", "1998"),
        Student("Воробьёв", "3", "1998"),
        Student("Фёдоров", "1", "2000"),
        Student("Михайлов", "3", "1998"),
        Student("Беляев", "2", "1999"),
        Student("Тарасов", "1", "2000"),
        Student("Белов", "1", "2000"),
        Student("Комаров", "4", "1997"),
        Student("Орлов", "1", "2000"),
        Student("Киселёв", "1", "2000"),
        Student("Макаров", "2", "1999"),
        Student("Андреев", "2", "1999"),
        Student("Ковалёв", "2", "1999"),
        Student("Ильин", "1", "2000"),
        Student("Гусев", "1", "2000"),
        Student("Титов", "1", "2000"),
        Student("Кузьмин", "2", "1998"),
        Student("Кудрявцев", "3", "1998"),
        Student("Баранов", "4", "1997"),
        Student("Куликов", "4", "1996"),
    )

    override fun onFirstViewAttach() {
        studentList = students
//        studentList = utils.getJSON()
        viewState.showStudentList(studentList)
    }

    fun processStudentClick(position: Int) {
        viewState.openAboutStudent(studentList[position])
    }

}
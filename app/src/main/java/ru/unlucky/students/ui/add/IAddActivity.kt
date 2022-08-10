package ru.unlucky.students.ui.add

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface IAddActivity: MvpView {

    @OneExecution
    fun close()

}
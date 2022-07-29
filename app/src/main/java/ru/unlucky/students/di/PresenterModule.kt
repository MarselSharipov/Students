package ru.unlucky.students.di

import org.koin.dsl.module
import ru.unlucky.students.ui.about.AboutPresenter
import ru.unlucky.students.ui.main.MainPresenter

val presenterModule = module {
    factory { MainPresenter(get()) }
    factory { AboutPresenter() }
}
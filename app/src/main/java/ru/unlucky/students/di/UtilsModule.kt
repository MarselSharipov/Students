package ru.unlucky.students.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.unlucky.students.ui.about.AboutPresenter
import ru.unlucky.students.ui.main.MainPresenter
import ru.unlucky.students.utils.Utils

val utilsModule = module {
    single { Utils(androidContext()) }
}
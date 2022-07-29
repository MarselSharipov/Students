package ru.unlucky.students.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(val name: String,
                   val course: String,
                   val year: String): Parcelable
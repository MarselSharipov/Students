package ru.unlucky.students.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.unlucky.students.data.Student

class Utils(private val context: Context) {

    fun getJSON(): List<Student> {
        var result = ""
        val inputStream = context.assets.open("data.json")
        try {
            result = inputStream.bufferedReader().use { it.readText() }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        } finally {
            inputStream.close()
        }

        val listStudentType = object: TypeToken<List<Student>>() {}.type
        return Gson().fromJson(result, listStudentType)
    }

}
package ru.unlucky.students.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.unlucky.students.data.Student
import java.io.File

class Utils(private val context: Context) {

    private val path = "${context.cacheDir}/data.json" // Путь к файлу

    // Метод для получения списка студентов
    fun getStudentsList(): MutableList<Student> {
        var result = "" // Переменная, куда записывается JSON-файл в текстовом виде
        val isFileExists = File(path).exists() // Проверка, существует ли нужный файл в cacheDir
        val inputStream = if (isFileExists) { // Если файл существует, то в переменную запишется InputStream уже файла из cacheDir
            File(path).inputStream()
        } else {
            context.assets.open("data.json") // Если файла не существует, то в переменную запишется InputStream из файла в assets
        }
        try {
            result = inputStream.bufferedReader().use { it.readText() } // Считывание данных из входного потока (InputStream)
            if (!isFileExists) writeDataToCacheFile(result) // Если файла не существует, то сразу запишутся считанные данные из assets файла
        } catch (e: Exception) {
            e.printStackTrace() // если упали в ошибку, то они напечатаются в логах
        } finally {
            inputStream.close() // закрытие входного потока
        }

        val listStudentType = object: TypeToken<List<Student>>() {}.type // указание, какого типа данные ждать из считанной строки (переменная result)
        return Gson().fromJson(result, listStudentType) // парсинг массива по указанному типу строки
    }

    // Метод, который перевод массив в json-строку и проваливается в сохранение новых данных в файл
    fun saveList(list: List<Student>) {
        val result = Gson().toJson(list) // получение данных из массива в виде json-строки
        writeDataToCacheFile(result) // вызов метода, для записи в файл
//        writeDataToCacheFile(Gson().toJson(list)) // Более короткая реализация
    }

    // Метод для сохранения json-строки в файл
    private fun writeDataToCacheFile(result: String) {
        if (!File(path).exists()) {
            File(path).createNewFile() // еще раз проверяем, существует ли файл, если нет, то создаем
        }
        val outputStream = File(path).outputStream() // открываем выходной поток
        try {
            outputStream.bufferedWriter().use { it.write(result) } // запись данных по выходному потоку
        } catch (e: Exception) {
            e.printStackTrace() // если упали в ошибку, то они напечатаются в логах
        } finally {
            outputStream.close()// закрытие выходного потока
        }
    }

}
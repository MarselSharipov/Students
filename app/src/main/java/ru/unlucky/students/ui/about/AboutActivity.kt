package ru.unlucky.students.ui.about

import android.content.Context
import android.content.Intent
import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.get
import ru.unlucky.students.R
import ru.unlucky.students.data.Student
import ru.unlucky.students.databinding.ActivityAboutBinding
import ru.unlucky.students.utils.Constants

class AboutActivity: MvpAppCompatActivity(), IAboutActivity {

    companion object {
        fun makeIntent(context: Context, student: Student) =
                Intent(context, AboutActivity::class.java)
                        .putExtra(Constants.Extras.STUDENT, student)
    }

    private lateinit var binding: ActivityAboutBinding

    private val presenter by moxyPresenter { get<AboutPresenter>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.student = intent.getParcelableExtra(Constants.Extras.STUDENT) ?: throw IllegalArgumentException("Student argument required")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun setStudent(student: Student) {
        binding.nameTextView.text = getString(R.string.name_about, student.name)
        binding.courseTextView.text = getString(R.string.course_about, student.course)
        binding.yearTextView.text = getString(R.string.year_about, student.year)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
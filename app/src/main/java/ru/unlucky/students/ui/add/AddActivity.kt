package ru.unlucky.students.ui.add

import android.content.Context
import android.content.Intent
import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import org.koin.android.ext.android.get
import ru.unlucky.students.databinding.ActivityAddBinding
import ru.unlucky.students.widgets.SimpleTextWatcher

class AddActivity: MvpAppCompatActivity(), IAddActivity {

    companion object {
        fun makeIntent(context: Context) =
                Intent(context, AddActivity::class.java)
    }

    private lateinit var binding: ActivityAddBinding

    private val presenter by moxyPresenter { get<AddPresenter>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.cancelButton.setOnClickListener { presenter.processCancelClick() }
        binding.actionButton.setOnClickListener { presenter.processActionClick() }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onResume() {
        super.onResume()
        binding.surnameEditText.addTextChangedListener(surnameTextWatcher)
        binding.courseEditText.addTextChangedListener(courseTextWatcher)
        binding.yearEditText.addTextChangedListener(yearTextWatcher)
    }

    override fun onPause() {
        binding.surnameEditText.removeTextChangedListener(surnameTextWatcher)
        binding.courseEditText.removeTextChangedListener(courseTextWatcher)
        binding.yearEditText.removeTextChangedListener(yearTextWatcher)
        super.onPause()
    }

    override fun close() {
        finish()
    }

    private val surnameTextWatcher = SimpleTextWatcher { presenter.processSurnameChange(it) }

    private val courseTextWatcher = SimpleTextWatcher { presenter.processCourseChange(it) }

    private val yearTextWatcher = SimpleTextWatcher { presenter.processYearChange(it) }

}
package org.poriad.planyourweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.joda.time.DateTime
import org.poriad.planyourweek.databinding.ActivityCalendarBinding
import org.poriad.planyourweek.model.adapter.CalendarAdapter
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.util.*
import java.util.Calendar.getInstance
import kotlin.collections.ArrayList

class CalendarActivity : AppCompatActivity(), CalendarAdapter.OnItemListener {

    private lateinit var binding : ActivityCalendarBinding
    private lateinit var selectedDate: DateTime
    private lateinit var adapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectedDate = DateTime.now()
        setMonthView()

    }

    private fun setMonthView() {
        binding.monthYearTV.text = getMonthYearFromDate(selectedDate)
        var daysInMonth: MutableList<String> = daysInMonthArray(selectedDate)

        adapter = CalendarAdapter(daysInMonth, this)
        binding.recyclerViewDays.adapter = adapter
        binding.recyclerViewDays.layoutManager = GridLayoutManager(this, 7)
    }

    private fun daysInMonthArray(selectedDate: DateTime): MutableList<String> {
        var daysInMonthArray: MutableList<String> = mutableListOf()
        var daysInMonth = selectedDate.dayOfMonth().maximumValue;
        var dayOfWeek = selectedDate.withDayOfMonth(1).dayOfWeek().get()
        for (num in 1..42) {
            if (num <= dayOfWeek || num > daysInMonth + dayOfWeek) {
                daysInMonthArray.add("")
            } else {
                daysInMonthArray.add("${num - dayOfWeek}")
            }
        }

        return daysInMonthArray
    }

    private fun getMonthYearFromDate(date: DateTime): String {

        return "${date.monthOfYear().asText} ${date.year().asShortText}"
    }
    fun previousMonthAction(view: View) {
        selectedDate = selectedDate.minusMonths(1)
        setMonthView()
    }

    fun nextMonthAction(view: View) {
        selectedDate = selectedDate.plusMonths(1)
        setMonthView()
    }

    override fun onItemClick(position: Int, dayText: String) {
            Toast.makeText(applicationContext, "Day selected: $dayText", Toast.LENGTH_LONG).show()
    }
}
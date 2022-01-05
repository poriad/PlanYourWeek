package org.poriad.planyourweek.utils

import org.joda.time.DateTime

class CalendarUtils {

    companion object {
        lateinit var instance: CalendarUtils
        val timeNow: DateTime = DateTime.now()

        fun daysInMonthArray(selectedDate: DateTime): MutableList<String> {
            var daysInMonthArray: MutableList<String> = mutableListOf()
            var daysInMonth = selectedDate.dayOfMonth().maximumValue;
            var dayOfWeek = selectedDate.withDayOfMonth(1).dayOfWeek().get()

            if (dayOfWeek == 7) {
                for (num in 1..35) {
                    if (num > daysInMonth + dayOfWeek || num > daysInMonth) {
                        daysInMonthArray.add("")
                    } else {
                        daysInMonthArray.add("$num")
                    }
                }
            } else {
                for (num in 1..42) {
                    if (num <= dayOfWeek || num > daysInMonth + dayOfWeek) {
                        daysInMonthArray.add("")
                    } else {
                        daysInMonthArray.add("${num - dayOfWeek}")
                    }
                }
            }
            return daysInMonthArray
        }

        fun getMonthYearFromDate(date: DateTime): String {

            return "${date.monthOfYear().asText} ${date.year().asShortText}"
        }
    }

    init {
        instance = this
    }
}
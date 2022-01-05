package org.poriad.planyourweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.poriad.planyourweek.databinding.ActivityWeekViewBinding

class WeekViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeekViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeekViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun previousWeekAction(view: View) {

    }

    fun nextWeekAction(view: View) {

    }
}
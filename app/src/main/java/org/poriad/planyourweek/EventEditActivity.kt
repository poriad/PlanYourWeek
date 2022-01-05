package org.poriad.planyourweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.poriad.planyourweek.databinding.ActivityEventEditBinding

class EventEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
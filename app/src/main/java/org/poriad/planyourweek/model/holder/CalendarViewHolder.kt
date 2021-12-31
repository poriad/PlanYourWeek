package org.poriad.planyourweek.model.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.poriad.planyourweek.databinding.CalendarCellBinding
import org.poriad.planyourweek.model.adapter.CalendarAdapter

class CalendarViewHolder(view: View, private val onItemSelectedListener: CalendarAdapter.OnItemListener) :RecyclerView.ViewHolder(view), View.OnClickListener  {

    private var binding = CalendarCellBinding.bind(view)


    fun bind(day: String) {
        binding.cellDayText.text = day
        binding.cellDayText.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        onItemSelectedListener.onItemClick(adapterPosition, binding.cellDayText.text.toString())
    }

}
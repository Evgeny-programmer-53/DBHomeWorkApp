package evgeny.company.dbhomeworkapp.secondscreen

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import evgeny.company.dbhomeworkapp.R

class SecondScreenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView

    init {
        title = itemView.findViewById(R.id.beerTitle)
    }
}
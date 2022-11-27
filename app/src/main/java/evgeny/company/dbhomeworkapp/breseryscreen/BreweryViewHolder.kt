package evgeny.company.dbhomeworkapp.breseryscreen

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import evgeny.company.dbhomeworkapp.R

class BreweryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val breweryTitle: TextView
    val breweryType: TextView

    init {
        breweryTitle = itemView.findViewById(R.id.breweryTitle)
        breweryType = itemView.findViewById(R.id.breweryType)
    }
}
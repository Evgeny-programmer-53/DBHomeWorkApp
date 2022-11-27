package evgeny.company.dbhomeworkapp.breseryscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import evgeny.company.dbhomeworkapp.R
import evgeny.company.dbhomeworkapp.api.BreweryDto

class BreweryAdapter(val breweryList: List<BreweryDto>) :
    RecyclerView.Adapter<BreweryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        return BreweryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.brewery_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        holder.breweryTitle.text = breweryList[position].name
        holder.breweryType.text = breweryList[position].breweryType
    }

    override fun getItemCount(): Int {
        return breweryList.size
    }
}
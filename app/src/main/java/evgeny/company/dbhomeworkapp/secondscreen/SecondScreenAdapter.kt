package evgeny.company.dbhomeworkapp.secondscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import evgeny.company.dbhomeworkapp.R
import evgeny.company.dbhomeworkapp.db.Beer

class SecondScreenAdapter(val context: Context, var beerList: List<Beer>) :
    RecyclerView.Adapter<SecondScreenViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondScreenViewHolder {
        return SecondScreenViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.beer_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SecondScreenViewHolder, position: Int) {
        holder.title.text = beerList[position].name
    }

    override fun getItemCount(): Int {
        return beerList.size
    }

    fun updateList(newBeerList: List<Beer>) {
        beerList = newBeerList
        notifyDataSetChanged()
        Toast.makeText(context, "База данных очищена", Toast.LENGTH_SHORT).show()
    }
}
package evgeny.company.dbhomeworkapp.secondscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import evgeny.company.dbhomeworkapp.App
import evgeny.company.dbhomeworkapp.R

class SecondScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance.getDb()
        val beerDao = db.beerDao()
        val beerList = beerDao.getAll()

        val recyclerView = view.findViewById<RecyclerView>(R.id.beerRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        val beerAdapter = SecondScreenAdapter(requireContext(), beerList)
        recyclerView.adapter = beerAdapter

        view.findViewById<Button>(R.id.clearDbButton).setOnClickListener {
            beerDao.deleteAll()
            val newBeerList = beerDao.getAll()
            beerAdapter.updateList(newBeerList)
        }
    }

}
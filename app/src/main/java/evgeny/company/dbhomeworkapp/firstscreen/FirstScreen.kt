package evgeny.company.dbhomeworkapp.firstscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import evgeny.company.dbhomeworkapp.App
import evgeny.company.dbhomeworkapp.R
import evgeny.company.dbhomeworkapp.Router
import evgeny.company.dbhomeworkapp.db.Beer

class FirstScreen : Fragment() {

    private var router: Router? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editText = view.findViewById<TextInputEditText>(R.id.beerInput)
        view.findViewById<Button>(R.id.addBeerButton).setOnClickListener {
            val beerTitle = editText.text.toString()
            val db = App.instance.getDb()
            val beerDao = db.beerDao()

            val beer = Beer(
                id = System.currentTimeMillis(),
                name = beerTitle
            )
            beerDao.insert(beer)
            editText.text?.clear()
            Toast.makeText(context, "$beerTitle добавлен в базу данных", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.openSecondScreenButton).setOnClickListener {
            router?.openSecondScreen()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Router) {
            router = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        router = null
    }
}
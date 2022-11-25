package evgeny.company.dbhomeworkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import evgeny.company.dbhomeworkapp.firstscreen.FirstScreen
import evgeny.company.dbhomeworkapp.secondscreen.SecondScreen

class MainActivity : AppCompatActivity(), Router {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FirstScreen())
            .commit()
    }

    override fun openSecondScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SecondScreen())
            .addToBackStack("")
            .commit()
    }
}
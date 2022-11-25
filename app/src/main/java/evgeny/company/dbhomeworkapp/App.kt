package evgeny.company.dbhomeworkapp

import android.app.Application
import androidx.room.Room
import evgeny.company.dbhomeworkapp.db.AppDatabase

class App: Application() {

    private lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database"
        )
            .allowMainThreadQueries()
            .build()
        instance = this
    }

    fun getDb() = db

    companion object {
        lateinit var instance: App
    }
}
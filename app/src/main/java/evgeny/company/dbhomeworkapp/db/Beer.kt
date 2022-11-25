package evgeny.company.dbhomeworkapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Beer(@PrimaryKey var id: Long = 0, var name: String = "")
package evgeny.company.dbhomeworkapp.db

import androidx.room.*

@Dao
interface BeerDao {

    @Query("SELECT * FROM beer")
    fun getAll(): List<Beer>

    @Query("DELETE FROM beer")
    fun deleteAll()

    @Query("SELECT * FROM beer WHERE id = :id")
    fun getById(id: Long): Beer?

    @Insert
    fun insert(beer: Beer)

    @Update
    fun update(beer: Beer)

    @Delete
    fun delete(beer: Beer?)

}
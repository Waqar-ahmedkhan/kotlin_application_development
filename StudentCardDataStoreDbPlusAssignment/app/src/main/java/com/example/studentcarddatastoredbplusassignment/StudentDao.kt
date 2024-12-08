import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.studentcarddatastoredbplusassignment.StudentEntity

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: StudentEntity)

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    fun getAllStudents(): LiveData<List<StudentEntity>>
}
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope // This should be recognized now
import com.example.studentcarddatastoredbplusassignment.StudentDatabase
import com.example.studentcarddatastoredbplusassignment.StudentEntity
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private val studentDao = StudentDatabase.getDatabase(application).studentDao()
    private val allStudents: LiveData<List<StudentEntity>> = studentDao.getAllStudents()

    fun getAllStudents(): LiveData<List<StudentEntity>> = allStudents

    fun insertStudent(student: StudentEntity) {
        viewModelScope.launch {
            studentDao.insertStudent(student)
        }
    }
}

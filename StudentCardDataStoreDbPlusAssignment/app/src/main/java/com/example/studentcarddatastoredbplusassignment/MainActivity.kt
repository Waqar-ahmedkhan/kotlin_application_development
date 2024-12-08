import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.studentcarddatastoredbplusassignment.R

class MainActivity : AppCompatActivity() {

    private lateinit var studentViewModel: StudentViewModel
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.studentRecyclerView)
        val fab = findViewById<FloatingActionButton>(R.id.addStudentButton)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        adapter = StudentAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        studentViewModel.getAllStudents().observe(this, Observer { students ->
            adapter = StudentAdapter(students)
            recyclerView.adapter = adapter
        })

        fab.setOnClickListener {
            val dialog = AddStudentDialog(this) { student ->
                studentViewModel.insertStudent(student)
                Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }
    }
}

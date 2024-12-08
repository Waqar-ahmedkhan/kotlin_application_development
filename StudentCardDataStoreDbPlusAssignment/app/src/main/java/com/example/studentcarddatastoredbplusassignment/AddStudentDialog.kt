import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.studentcarddatastoredbplusassignment.R
import com.example.studentcarddatastoredbplusassignment.StudentEntity

class AddStudentDialog(
    context: Context,
    private val onStudentAdded: (StudentEntity) -> Unit
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_student)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val ageInput = findViewById<EditText>(R.id.ageInput)
        val gradeInput = findViewById<EditText>(R.id.gradeInput)
        val addButton = findViewById<Button>(R.id.addStudentConfirmButton)

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val age = ageInput.text.toString().toIntOrNull()
            val grade = gradeInput.text.toString()

            if (name.isNotEmpty() && age != null && grade.isNotEmpty()) {
                val student = StudentEntity(name = name, age = age, grade = grade)
                onStudentAdded(student)
                dismiss()
            } else {
                nameInput.error = "Invalid Input"
            }
        }
    }
}

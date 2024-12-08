import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentcarddatastoredbplusassignment.R
import com.example.studentcarddatastoredbplusassignment.StudentEntity

class StudentAdapter(private val studentList: List<StudentEntity>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.studentName)
        val ageText: TextView = itemView.findViewById(R.id.studentAge)
        val gradeText: TextView = itemView.findViewById(R.id.studentGrade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_card, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.nameText.text = "Name: ${student.name}"
        holder.ageText.text = "Age: ${student.age}"
        holder.gradeText.text = "Grade: ${student.grade}"
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}
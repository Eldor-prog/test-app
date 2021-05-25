package uz.eldor.testapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.eldor.testapp.R
import uz.eldor.testapp.model.QuizModel
import uz.eldor.testapp.model.ScienceModel
import uz.eldor.testapp.view.SciencesAdapter
import uz.eldor.testapp.view.SciencesAdapterCallback

class SciencesActivity : AppCompatActivity() {
    private val sciences = listOf(
        ScienceModel("Matematika", listOf(
            QuizModel("2 ning kvadrati?",R.drawable.test,
                "4 ga teng",
                "5 ga teng",
                "3 ga teng",
                "TJY",
                "A"),
            QuizModel("4 ning kvadrati?",null,
                "5 ga teng",
                "16 ga teng",
                "7 ga teng",
                "9 ga teng",
                "B"),
            QuizModel("2*2 = ?",R.drawable.test,
                "5 ga teng",
                "4 ga teng",
                "7 ga teng",
                "9 ga teng",
                "B")
        )),
        ScienceModel("Ona tili", emptyList()),
        ScienceModel("Fizizka", emptyList()),
        ScienceModel("Informatika", emptyList())

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sciences)
        val rv:RecyclerView = findViewById(R.id.recycler_view_fanlar);
        findViewById<ImageView>(R.id.image_view_back).setOnClickListener {
            finish()
        }

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = SciencesAdapter(sciences, object : SciencesAdapterCallback{
            override fun onClick(item: ScienceModel) {
                val intent = Intent(this@SciencesActivity, QuizActivity::class.java)
                intent.putExtra("extra", item)
                startActivity(intent)
            }
        })

    }
}
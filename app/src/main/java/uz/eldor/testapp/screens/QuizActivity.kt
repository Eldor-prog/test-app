package uz.eldor.testapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import uz.eldor.testapp.R
import uz.eldor.testapp.model.ScienceModel

class QuizActivity : AppCompatActivity() {
    private lateinit var science:ScienceModel
    private lateinit var title:TextView
    private lateinit var image:ImageView
    private lateinit var answer_A:MaterialButton
    private lateinit var answer_B:MaterialButton
    private lateinit var answer_C:MaterialButton
    private lateinit var answer_D:MaterialButton
    var index = 0
    var correctCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        initViews()
        science = intent.getSerializableExtra("extra") as ScienceModel
        setQuiz()

        findViewById<ImageView>(R.id.image_view_back2).setOnClickListener { finish() }

        answer_A.setOnClickListener{
            if (science.quizList[index].correctAnswer == "A"){
                correctCount++
            }
            index++
            setQuiz()
        }
        answer_B.setOnClickListener{
            if (science.quizList[index].correctAnswer == "B"){
                correctCount++
            }
            index++
            setQuiz()
        }
        answer_C.setOnClickListener{
            if (science.quizList[index].correctAnswer == "C"){
                correctCount++
            }
            index++
            setQuiz()
        }
        answer_D.setOnClickListener{
            if (science.quizList[index].correctAnswer == "D"){
                correctCount++
            }
            index++
            setQuiz()
        }

    }
    fun initViews(){
        title = findViewById(R.id.text_view_question)
        image = findViewById(R.id.img_view_question)

        answer_A =  findViewById(R.id.answer_a)
        answer_B =  findViewById(R.id.answer_b)
        answer_C =  findViewById(R.id.answer_c)
        answer_D =  findViewById(R.id.answer_d)

    }

    fun setQuiz(){
        if (index < science.quizList.count()){
            val quiz = science.quizList[index]
             title.text = quiz.title
            if (quiz.image != null){
                image.visibility = View.VISIBLE
                image.setImageResource(quiz.image)
            }else{
                image.visibility = View.GONE
            }
            answer_A.text = quiz.answerA
            answer_B.text = quiz.answerB
            answer_C.text = quiz.answerC
            answer_D.text = quiz.answerD
        }else{
            Toast.makeText(this,
                "Siz ${science.quizList.count()} ta savoldan $correctCount tasiga to`g`ri javob berdingiz!",
                Toast.LENGTH_LONG)
                .show()
            finish()
        }
    }

}
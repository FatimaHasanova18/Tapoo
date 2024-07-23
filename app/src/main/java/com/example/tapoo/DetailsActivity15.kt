package com.example.tapoo


import CustomCountdownTimer
import android.os.CountDownTimer
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tapoo.databinding.ActivityDetails15Binding
import com.example.tapoo.databinding.Layaut1Binding
import java.text.DecimalFormat

class DetailsActivity15 : AppCompatActivity() {
    private lateinit var binding: ActivityDetails15Binding
    private var currentWordIndex = 0
    private lateinit var customCountdownTimer: CustomCountdownTimer

    private val yemekList = listOf(
        listOf("Hamburger", "Hamburger", "Pizza", "Pasta","Steak","Salad"),
        listOf("Pizza", "Hamburger", "Pi", "Pasta","Steak","Salad"),
        listOf("Pasta", "Hamburger", "Piz", "Pasta","Steak","Salad"),
        listOf("Steak", "Hamburger", "P", "Pasta","Steak","Salad"),
        listOf("Salad", "Hamburger", "a", "Pasta","Steak","Salad"))
    private val olkeList = listOf(
        listOf("Türkiye", "Türkiye", "Almanya", "İtalya","İspanya","Fransa"),
        listOf("Alma","Türkiye", "Alnya", "İtalya","İspanya","Fransa"),
        listOf("İt","Türkiye", "Almanya", "İlya","İspanya","Fransa"),
        listOf("İspya","Tüiye", "Almanya", "İtalya","anya","Fransa"),
        listOf("İspya","Tüiye", "Almanya", "İtalya","anya","Fransa"))
    private val meshurList = listOf(
        listOf( "Kırmızı","Kıızı", "Mavi", "Yeşil","Sarı","Mor"),
        listOf("Mavi","Kırmızı", "Mavi", "Yeşil","Sarı","Mor"),
        listOf("Yeşil", "ızı", "Mavi", "Yeşil","Sarı","Mor"),
        listOf("Sarı","Kırmızı", "Mavi", "Yeşil","Sarı","Mor"),
        listOf("Sarı","Kırm", "Mavi", "Yeşil","Sarı","Mor"))
    private lateinit var CountDownTimer: CountDownTimer
    private var timeLeftInMills: Long = 10000
    private var score1 = 0
    private var score2 = 0
    private var score3 = 0
    private var score4 = 0
    private var isFirstTeam = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetails15Binding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        updateScore()
        startTimer()
        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()

        val intent=intent
        var keyword=intent.getStringExtra("keyword")
        if(keyword=="yemek"){
            binding.wordEditText.setText(yemekList[currentWordIndex][0].toString())
            binding.tabooWordEditText1.setText(yemekList[currentWordIndex][1].toString())
            binding.tabooWordEditText2.setText(yemekList[currentWordIndex][2].toString())
            binding.tabooWordEditText3.setText(yemekList[currentWordIndex][3].toString())
            binding.tabooWordEditText4.setText(yemekList[currentWordIndex][4].toString())
            binding.tabooWordEditText5.setText(yemekList[currentWordIndex][5].toString())
        }else if(keyword=="olke"){
            binding.wordEditText.setText(olkeList[0][0].toString())
            binding.tabooWordEditText1.setText(olkeList[0][1].toString())
            binding.tabooWordEditText2.setText(olkeList[0][2].toString())
            binding.tabooWordEditText3.setText(olkeList[0][3].toString())
            binding.tabooWordEditText4.setText(olkeList[0][4].toString())
            binding.tabooWordEditText5.setText(olkeList[0][5].toString())
        }else if(keyword=="meshur"){
            binding.wordEditText.setText(meshurList[0][0].toString())
            binding.tabooWordEditText1.setText(meshurList[0][1].toString())
            binding.tabooWordEditText2.setText(meshurList[0][2].toString())
            binding.tabooWordEditText3.setText(meshurList[0][3].toString())
            binding.tabooWordEditText4.setText(meshurList[0][4].toString())
            binding.tabooWordEditText5.setText(meshurList[0][5].toString())
        }
        binding.passed.setOnClickListener {
            currentWordIndex++
            Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()
            println("Hello")
//    binding.wordEditText.setText(yemekList[currentWordIndex][0].toString())
//    binding.tabooWordEditText1.setText(yemekList[currentWordIndex][1].toString())
//    binding.tabooWordEditText2.setText(yemekList[currentWordIndex][2].toString())
//    binding.tabooWordEditText3.setText(yemekList[currentWordIndex][3].toString())
//    binding.tabooWordEditText4.setText(yemekList[currentWordIndex][4].toString())
//    binding.tabooWordEditText5.setText(yemekList[currentWordIndex][5].toString())
            if(keyword=="yemekler"){
                binding.wordEditText.setText(yemekList[currentWordIndex][0].toString())
                binding.tabooWordEditText1.setText(yemekList[currentWordIndex][1].toString())
                binding.tabooWordEditText2.setText(yemekList[currentWordIndex][2].toString())
                binding.tabooWordEditText3.setText(yemekList[currentWordIndex][3].toString())
                binding.tabooWordEditText4.setText(yemekList[currentWordIndex][4].toString())
                binding.tabooWordEditText5.setText(yemekList[currentWordIndex][5].toString())

            }else if(keyword=="olkeler"){
                binding.wordEditText.setText(olkeList[0][0].toString())
                binding.tabooWordEditText1.setText(olkeList[currentWordIndex][1].toString())
                binding.tabooWordEditText2.setText(olkeList[currentWordIndex][2].toString())
                binding.tabooWordEditText3.setText(olkeList[currentWordIndex][3].toString())
                binding.tabooWordEditText4.setText(olkeList[currentWordIndex][4].toString())
                binding.tabooWordEditText5.setText(olkeList[currentWordIndex][5].toString())

            }else if(keyword=="meshurlar"){
                binding.wordEditText.setText(meshurList[0][0].toString())
                binding.tabooWordEditText1.setText(meshurList[currentWordIndex][1].toString())
                binding.tabooWordEditText2.setText(meshurList[currentWordIndex][2].toString())
                binding.tabooWordEditText3.setText(meshurList[currentWordIndex][3].toString())
                binding.tabooWordEditText4.setText(meshurList[currentWordIndex][4].toString())
                binding.tabooWordEditText5.setText(meshurList[currentWordIndex][5].toString())

            }
        }

        binding.truee.setOnClickListener {
            if (isFirstTeam) {
                score1++
            } else {
                score2++
            }
            updateScore()
        }

        binding.falsee.setOnClickListener {
            if (isFirstTeam) {
                score3++
            } else {
                score4++
            }
            updateScore()
        }
            binding.sstopp.setOnClickListener {
        customCountdownTimer.pauseTimer()
        showCustomDialog()
    }
    }


    private fun timerFormat(secondsLeft: Int) {
        val decimalFormat = DecimalFormat("00")
        val hour = secondsLeft / 3600
        val min = (secondsLeft % 3600) / 60
        val seconds = secondsLeft % 60

        val timeFormat = "${decimalFormat.format(hour)}:${decimalFormat.format(min)}:${decimalFormat.format(seconds)}"
        binding.timeTxt.text = timeFormat
    }
    private fun updateWord(){
        val currentWord = yemekList[currentWordIndex]
        binding.wordEditText.setText(currentWord[0])
        binding.tabooWordEditText1.setText(currentWord[1])
        binding.tabooWordEditText2.setText(currentWord[2])
        binding.tabooWordEditText3.setText(currentWord[3])
        binding.tabooWordEditText4.setText(currentWord[4])
        binding.tabooWordEditText5.setText(currentWord[5])
        val currentWordOlke = olkeList[currentWordIndex]
        binding.wordEditText.setText(currentWordOlke[0])
        binding.tabooWordEditText1.setText(currentWordOlke[1])
        binding.tabooWordEditText2.setText(currentWordOlke[2])
        binding.tabooWordEditText3.setText(currentWordOlke[3])
        binding.tabooWordEditText4.setText(currentWordOlke[4])
        binding.tabooWordEditText5.setText(currentWordOlke[5])
        val currentWordMeshur = meshurList[currentWordIndex]
        binding.wordEditText.setText(currentWordMeshur[0])
        binding.tabooWordEditText1.setText(currentWordMeshur[1])
        binding.tabooWordEditText2.setText(currentWordMeshur[2])
        binding.tabooWordEditText3.setText(currentWordMeshur[3])
        binding.tabooWordEditText4.setText(currentWordMeshur[4])
        binding.tabooWordEditText5.setText(currentWordMeshur[5])

    }
    private  fun nextWord(){
        currentWordIndex = (currentWordIndex + 1) % yemekList.size
        updateWord()
        currentWordIndex = (currentWordIndex + 1) % olkeList.size
        updateWord()
        currentWordIndex = (currentWordIndex + 1) % meshurList.size
        updateWord()

    }

    private fun startTimer() {
        CountDownTimer = object : CountDownTimer(timeLeftInMills, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.linearProgressBar.progress = (timeLeftInMills / 1000).toInt()

                timeLeftInMills = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                Log.d("DetailsActivity15", "Timer finished")
                if (isFirstTeam) {
                    showSwitchTeamDialog()
                } else {
                    showGameOverDialog()
                }
            }
        }.start()
    }
    private fun showCustomDialog() {
        val dialogBinding = Layaut1Binding.inflate(layoutInflater)
        val dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root)
        dialogBinding.but.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.but2.setOnClickListener {
            resumeGame()
            dialog.dismiss()
        }
        dialogBinding.but3.setOnClickListener {
            val intent = Intent(this, DetailsActivity15::class.java)
            startActivity(intent)
        }
        dialogBinding.ev.setOnClickListener {
            val intent = Intent(this, DetailsActivity1::class.java)
            startActivity(intent)
        }
//        dialogBinding.sesss.visibility= View.VISIBLE
//        dialogBinding.sessiz.visibility= View.INVISIBLE
//        dialogBinding.sesss.setOnClickListener {
//            dialogBinding.sesss.visibility = View.INVISIBLE
//            dialogBinding.sessiz.visibility = View.VISIBLE
//        }
//        dialogBinding.sessiz.setOnClickListener {
//            dialogBinding.sesss.visibility = View.VISIBLE
//            dialogBinding.sessiz.visibility = View.INVISIBLE
//        }
        dialog.show()
    }
    private fun resumeGame() {
        customCountdownTimer.resumeTimer()
    }
    private fun updateTimerText() {
        val seconds = (timeLeftInMills / 1000).toInt()
        binding.timeTxt.text = seconds.toString()
    }

    private fun updateScore() {
        binding.score1.text = score1.toString()
        binding.score2.text = score2.toString()
    }

    private fun showSwitchTeamDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.layout4,null)
        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialogTitle)
        val dialogMessage = dialogView.findViewById<TextView>(R.id.dialogMessage)
        val dialogButton = dialogView.findViewById<Button>(R.id.dialogButton)
        dialogTitle.text = "Time's up!"
        dialogMessage.text = "Do you want to switch to the second team?"

        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        dialogButton.setOnClickListener {
            dialog.dismiss()
            isFirstTeam = false
            timeLeftInMills = 30000
            startTimer()
        }

        dialog.show() // Show the dialog after setting up the button click listener
    }

    private fun showGameOverDialog() {
        Log.d("DetailsActivity15", "showGameOverDialog called")
        val dialogView = LayoutInflater.from(this).inflate(R.layout.layaout2, null)
        val qazanan = dialogView.findViewById<TextView>(R.id.qazanan)
        val score1TextView = dialogView.findViewById<TextView>(R.id.score1TextView)
        val score2TextView = dialogView.findViewById<TextView>(R.id.score2TextView)
        val score3TextView = dialogView.findViewById<TextView>(R.id.uc)
        val score4TextView = dialogView.findViewById<TextView>(R.id.dord)

        if (score1 > score2) {
            qazanan.text = "Group 1"
        } else if (score2 > score1) {
            qazanan.text = "Group 2"
        } else {
            qazanan.text = "It's a tie!"
        }

        score1TextView.text = "$score1"
        score2TextView.text = "$score2"
        score3TextView.text = "$score3"
        score4TextView.text = "$score4"

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        dialog.show()
    }
}

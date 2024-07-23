package com.example.tapoo

import CustomCountdownTimer
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.content.pm.ActivityInfo
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapoo.databinding.ActivityDetails12Binding
import com.example.tapoo.databinding.Layaut1Binding
import com.example.tapoo.databinding.Layaut3Binding
import java.text.DecimalFormat
import kotlin.math.roundToInt

class DetailsActivity12 : AppCompatActivity() {
    private lateinit var binding: ActivityDetails12Binding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var customCountdownTimer: CustomCountdownTimer
    private var correctAnswerCount = 0
    private var incorrectAnswerCount = 0
    private var currentWordIndex = 0
    private val yemekList = listOf(
        listOf("Dolma", "Üzüm yarpagi", "Ət", "Plov","Qazmaq","Azerbaycan"),
        listOf("Plov", "Düyü", "Yağ", "Ət","Qazmaq","qızılgül suyu"),
        listOf("Kabab", "Ət", "Şiş", "Mangal","Kömür","Bişirmək"),
        listOf("Piti", "Ət", "Noxud", "Küp","Bişmək","qazmaq"),
        listOf("Bozbash", "Noxud", "Ət", "Kartof","Şorba","Azərbaycan"),
        listOf("Baklava", "Şərbət", "Qoz", "Şirin","Yufqa","Bayram"),
        listOf("Ləvəngi", "Toyuq", "Soğan", "Qoz","Bişirmək","Qazmaq"))
    private val olkeList = listOf(
        listOf("Azərbaycan", "Bakı", "Qafqaz", "Xəzər","Neft","Qarabağ"),
        listOf("Türkiyə","Ankara", "İstanbul", "Kebab","Bosfor","Ölkə"),
        listOf("Rusiya","Moskva", "Kreml", "Sibir","Vodka","Matruşka"),
        listOf("Yaponiya","Tokio", "Sushi", "Samuray","Kimono","Fuji"),
        listOf("Fransa","Paris", "Eyfel", "Şərab","Luvr","Qalmakal"),
        listOf("Hindistan","YeniDehli", "Curry", "Qanq","Bolivud","Təcili"),
        listOf("İspanya","Madrid", "Fklamenco", "Faella","İbiza","La Liga"),
        listOf("Misir","Qahirə", "Piramidalar", "Sfinks","Nil","Firaun"),
        listOf("Kanada","Ottava", "Ahçığ", "Toronto","Hokkay","Maunties"))
    private val meshurList = listOf(
        listOf( "Kırmızı","Kıızı", "Mavi", "Yeşil","Sarı","Mor"),
        listOf("Mavi","Kırmızı", "Mavi", "Yeşil","Sarı","Mor"),
        listOf("Yeşil", "ızı", "Mavi", "Yeşil","Sarı","Mor"),
        listOf("Sarı","Kırmızı", "Mavi", "Yeşil","Sarı","Mor"),
        listOf("Sarı","Kırm", "Mavi", "Yeşil","Sarı","Mor"))

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetails12Binding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        enableEdgeToEdge()
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
        sharedPreferences = getSharedPreferences("gameSettings", MODE_PRIVATE)
loadSettings()

        Log.d("DetailsActivity12", "Trying to get 'time' from SharedPreferences")

        val selectedTimeStr = sharedPreferences.getString("time", "30")
        val selectedTime = selectedTimeStr?.toIntOrNull() ?: 30

        Log.d("DetailsActivity12", "Selected time: $selectedTime")

        val clockTime = (selectedTime * 1000).toLong()

        binding.truee.setOnClickListener {
            Log.d("DetailsActivity12", "truee clicked")
            correctAnswerCount++
            updateScore()
        }

        binding.tamamla.setOnClickListener {
            Log.d("DetailsActivity12", "tamamla clicked")
            correctAnswerCount++
            updateScore()
        }

        binding.arrow.setOnClickListener {
            Log.d("DetailsActivity12", "arrow clicked")
            val intent = Intent(this, Level::class.java)
            startActivity(intent)
        }

        binding.falsee.setOnClickListener {
            incorrectAnswerCount++
            updateScore()
        }

        binding.falseee.setOnClickListener {
            incorrectAnswerCount++
            updateScore()
        }

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        setupTimer(clockTime)
        customCountdownTimer.startTimer()

        binding.sstopp.setOnClickListener {
            customCountdownTimer.pauseTimer()
            showCustomDialog()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun loadSettings() {
        val language = sharedPreferences.getString("language", "")
        val time = sharedPreferences.getString("time", "")
        val passCount = sharedPreferences.getInt("pass_count", 0)

        Log.d("DetailsActivity", "Settings loaded: Language=$language, Time=$time, PassCount=$passCount")

        binding.timeTxt.text = time
    }

    private fun setupTimer(time: Long) {
        customCountdownTimer = CustomCountdownTimer(time, 1000)
        customCountdownTimer.onTick = { millisUntilFinished ->
            val secondsLeft = (millisUntilFinished / 1000.0f).roundToInt()
            timerFormat(secondsLeft)
        }
        customCountdownTimer.onFinish = {
            timerFormat(0)
            showResultsDialog()
        }
        binding.linearProgressBar.max = (time / 1000).toInt()
    }

    private fun timerFormat(secondsLeft: Int) {
        val decimalFormat = DecimalFormat("00")
        val hour = secondsLeft / 3600
        val min = (secondsLeft % 3600) / 60
        val seconds = secondsLeft % 60

        val timeFormat = "${decimalFormat.format(hour)}:${decimalFormat.format(min)}:${decimalFormat.format(seconds)}"
        binding.timeTxt.text = timeFormat
    }

    private fun updateScore() {
        binding.score.text = correctAnswerCount.toString()
    }

    private fun onBackPressedMethod() {
        customCountdownTimer.destroyTimer()
        finish()
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
            val intent = Intent(this, DetailsActivity12::class.java)
            startActivity(intent)
        }
        dialogBinding.ev.setOnClickListener {
            val intent = Intent(this, DetailsActivity1::class.java)
            startActivity(intent)
        }
//        binding.sesss.setOnClickListener {
//            dialogBinding.sesss.visibility = View.GONE
//            dialogBinding.sessiz.visibility = View.VISIBLE
//        }
//        binding.sessiz.setOnClickListener {
//            dialogBinding.sesss.visibility = View.VISIBLE
//            dialogBinding.sessiz.visibility = View.GONE
//        }
        dialog.show()
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
    private fun showResultsDialog() {
        val dialogBinding = Layaut3Binding.inflate(layoutInflater)
        val dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root)

        dialogBinding.trueAnswerCount.text = correctAnswerCount.toString()
        dialogBinding.falseAnswerCount.text = incorrectAnswerCount.toString()
        dialogBinding.ev.setOnClickListener {
            val intent = Intent(this, DetailsActivity1::class.java)
            startActivity(intent)
        }
        dialogBinding.restart.setOnClickListener {
            val intent = Intent(this, DetailsActivity12::class.java)
            startActivity(intent)
        }
        dialog.show()
    }

    private fun resumeGame() {
        customCountdownTimer.resumeTimer()
    }
}

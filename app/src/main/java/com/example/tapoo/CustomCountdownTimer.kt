import android.os.CountDownTimer

open class CustomCountdownTimer(
    private val millisInFuture: Long,
    private val countDownInterval: Long
) {
    private var millisUntilFinished = millisInFuture
    private var timer: CountDownTimer? = null
    private var isRunning = false
    var onTick: ((millisUntilFinished: Long) -> Unit)? = null
    var onFinish: (() -> Unit)? = null

    fun startTimer() {
        if (isRunning) return
        timer = object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                this@CustomCountdownTimer.millisUntilFinished = millisUntilFinished
                onTick?.invoke(millisUntilFinished)
            }

            override fun onFinish() {
                this@CustomCountdownTimer.millisUntilFinished = 0
                onFinish?.invoke()
            }
        }.start()
        isRunning = true
    }

    fun pauseTimer() {
        timer?.cancel()
        isRunning = false
    }

    fun resumeTimer() {
        if (!isRunning) {
            startTimer()
        }
    }

    fun restartTimer() {
        timer?.cancel()
        millisUntilFinished = millisInFuture
        startTimer()
    }

    fun destroyTimer() {
        timer?.cancel()
        isRunning = false
    }
}

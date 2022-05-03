import java.lang.Math.round
import kotlin.math.roundToInt

const val MINUTE = 60
const val HOUR = 60 * 60
const val DAY = 60 * 60 * 24
const val `TWO-DAYS` = 60 * 60 * 24 * 2
const val `THREE-DAYS` = 60 * 60 * 24 * 3

fun agoToText(seconds: Int): String {
    return when {
        seconds <= MINUTE -> "был(а) только что"
        seconds in (MINUTE + 1)..HOUR -> "был(а) ${minutesAgo(seconds)}"
        seconds in (HOUR + 1)..DAY -> "был(а) ${hoursAgo(seconds)}"
        seconds in (DAY + 1)..`TWO-DAYS` -> "был(а) сегодня"
        seconds in (`TWO-DAYS` + 1)..`THREE-DAYS` -> "был(а) вчера"
        else -> "был(а) давно"
    }

}

fun minutesAgo(second: Int): String {
val secondsInMunite = MINUTE.toDouble()
    val minutes : Double = (second / secondsInMunite)
    val minutesRound :Int = minutes.roundToInt()
    val tenResult:Int = minutesRound %10
    val hundredResult: Int = minutesRound %100
    val minutesVariant: String = when {
        tenResult ==1 && hundredResult !=11 -> "минуту"
        tenResult  in 2..4  -> "минуты"
        else  -> "минут"
    }
    return "$minutesRound $minutesVariant назад"
}



fun hoursAgo(second: Int): String {
    val secondsInHour = HOUR.toDouble()
    val hours : Double = (second / secondsInHour)
    val hoursRound :Int = hours.roundToInt()
    val tenResult:Int = hoursRound %10
    val hundredResult: Int = hoursRound %100
    val hoursVariant: String = when {
        tenResult ==1  -> "час"
        tenResult  in 2..4  -> "часа"
        else  -> "часов"
    }
    return "$hoursRound $hoursVariant назад"
}

fun main() {
    println(agoToText(55))
    println(agoToText(65))
    println(agoToText(120))
    println(agoToText(305))
    println(agoToText(359))
    println(agoToText(3_700))
    println(agoToText(80_000))
    println(agoToText(18_000))
    println(agoToText(90_000))
    println(agoToText(172_900))
    println(agoToText(300_000))

}




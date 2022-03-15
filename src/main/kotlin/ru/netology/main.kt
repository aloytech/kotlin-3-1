package ru.netology

fun main() {
    println("Пользователь был в сети " + agoToText(45))
    for (i in 1..8) {
        println("Пользователь был в сети " + agoToText(60 * i * i + 5))
    }
    for (i in 1..5) {
        println("Пользователь был в сети " + agoToText(60 * 60 * (i * i + 2) + 5))
    }
    println("Пользователь был в сети " + agoToText(2*24*60*60+5))
    println("Пользователь был в сети " + agoToText(3*24*60*60+5))

}

fun agoToText(pastTime: Int): String {
    return when {
        pastTime <= 60 -> "только что"
        pastTime <= 3600 -> minutesAgo(pastTime)
        pastTime <= 24 * 60 * 60 -> hoursAgo(pastTime)
        pastTime <= 2 * 24 * 60 * 60 -> "сегодня"
        pastTime <= 3 * 24 * 60 * 60 -> "вчера"
        else -> "давно"
    }
}

fun minutesAgo(pastTime: Int): String {
    val minutes = pastTime / 60
    return when {
        minutes in 5..20 -> "$minutes минут назад"
        minutes % 10 == 1 -> "$minutes минуту назад"
        minutes % 10 in 2..4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursAgo(pastTime: Int): String {
    val hours = pastTime / 3600
    return when {
        hours in 5..20 -> "$hours часов назад"
        hours % 10 == 1 -> "$hours час назад"
        hours % 10 in 2..4 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}
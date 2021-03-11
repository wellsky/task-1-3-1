fun main() {
    println("Был(а) " + agoToText(20));
    println("Был(а) " + agoToText(80));
    println("Был(а) " + agoToText(120));
    println("Был(а) " + agoToText(2800));
    println("Был(а) " + agoToText(7800));
    println("Был(а) " + agoToText(173000));
    println("Был(а) " + agoToText(9999999));
}

fun agoToText(secondsAgo: Int): String {
    return when (secondsAgo) {
        in 0 .. 60 -> "только что"
        in 61 .. 60 * 60 -> (secondsAgo / 60).toString() + " " + minutes(secondsAgo) + " назад"
        in 60 * 60 + 1 .. 60 * 60 * 24 -> (secondsAgo / 3600).toString() + " " + hours(secondsAgo ) + " назад"
        in 60 * 60 * 24 + 1 ..  60 * 60 * 24 * 2 -> "сегодня"
        in 60 * 60 * 24 * 2 + 1 .. 60 * 60 * 24 * 3 -> "вчера"
        else -> "давно"
    }
}

fun minutes(seconds: Int): String {
    return countWord(seconds / 60, "минуту", "минуты", "минут")
}

fun hours(seconds: Int): String {
    return countWord(seconds / 3600, "час", "часа", "часов")
}

fun countWord(count: Int, form1: String, form2: String, form5: String): String {
    // Универсальная функция для приведения формы любых существительных
    return when (count % 10) {
        1 -> form1
        2,3,4 -> form2
        else -> form5
    }
}
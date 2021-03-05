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
    return when {
        (secondsAgo < 60) -> "только что"
        (secondsAgo < 3600) -> (secondsAgo / 60).toString() + " " + countWord(secondsAgo / 60, "минуту", "минуты", "минут") + " назад"
        (secondsAgo < 3600 * 24) -> (secondsAgo / 3600).toString() + " " + countWord(secondsAgo / 3600, "час", "часа", "часов") + " назад"
        (secondsAgo < 3600 * 24 * 2) -> "сегодня"
        (secondsAgo < 3600 * 24 * 3) -> "вчера"
        else -> "давно"
    }
}

fun countWord(count: Int, form1: String, form2: String, form5: String): String {
    // Универсальная функция для приведения формы любых существительных
    return when (count % 10) {
        1 -> form1
        2,3,4 -> form2
        else -> form5
    }
}
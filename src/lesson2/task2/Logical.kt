@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    if (number < 1000 || number > 10000) return false
    val n1 = number / 1000
    val n2 = (number / 100) % 10
    val n3 = (number / 10) % 10
    val n4 = number % 10

    return when {
        n1 + n2 == n3 + n4 -> true
        else -> false
    }
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    return x1 == x2 || y1 == y2 || x1 + y1 == x2 + y2 || x1 - y1 == x2 - y2
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 * Год високосный, если он делится на четыре без остатка, но если он делится на 100 без остатка,
 * это не високосный год. Однако, если он делится без остатка на 400, это високосный год.
 * Таким образом, 2000 г. является особым високосным годом, который бывает лишь раз в 400 лет.
 */
fun daysInMonth(month: Int, year: Int): Int {
    //400-проверка на 2000 год, т.к. такой високосный бывает только раз в 400 лет.
    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))
            and (month == 2)) return 29
    return when {
        month == 2 -> 28
        month % 2 == 0 && month != 8 -> 30
        else -> 31
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    val distance = Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0))
    return r2 >= distance + r1
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean{

    val l = Math.min(Math.min(a,b),c)
    val w = Math.max(Math.max(a,b),c)
    val h = a+b+c-w-l

    val hl = Math.min(r,s)
    val hh = Math.max(r,s)

    return l <= hl && h <= hh
}

fun main() {
    val orderSum = 999;
    var lastSum = 0
    var card = "Mastercard"

//    println(cardType(card, lastSum, orderSum))
   println(limit(card, orderSum, lastSum))
    println(pay(card, orderSum, lastSum))
    lastSum += orderSum
}

fun cardType(card: String, lastSum: Int, orderSum: Int): Int {
    var ans = 0
    var limitChecker = false
    limitChecker = lastSum + orderSum <= 75_000
    when (card) {
        "VK Pay" -> ans = 0

        "Mastercard", "Maestro" -> if (limitChecker) {
            ans = 0
        } else {
            ans = ((lastSum + orderSum) * 0.06 + 20).toInt()
        }

        "Visa", "Мир" -> if (orderSum * 0.075 < 35) {
            ans = 35
        } else {
            ans = (orderSum * 0.075).toInt()
        }
    }
    return ans
}

fun limit(card: String, lastSum: Int, orderSum: Int): Boolean {
    var status = false
    if (card != "VK Pay") {
        when {
            (orderSum > 150_000) -> status = false
            (orderSum + lastSum > 600_000) -> status = false
            else -> status = true
        }
    } else {
        when {
            (orderSum > 15_000) -> status = false
            (orderSum + lastSum > 40_000) -> status = false
            else -> status = true
        }
    }

    return status
}

fun pay(card: String = "VKPay", lastSum: Int = 0, orderSum: Int): String {
    var pay = "Ошибка оплаты!"
    var comision = cardType(card, lastSum, orderSum)
    if (limit(card, lastSum, orderSum)) {
        when (comision) {
            0 -> pay = "Комиссия не взымается"
            else -> pay = "Комиссия составит $comision рублей"
        }
    } else {
        pay = "Превышен лимит"
    }

    return pay
}
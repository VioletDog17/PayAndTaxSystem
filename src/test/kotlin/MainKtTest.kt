
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun VKoverLimit() {
        val orderSum = 999
        var lastSum = 700_000
        var card = "VK Pay"
        val result = limit(card, orderSum, lastSum)
        assertEquals(false, result)
    }
    @Test
    fun VKoverLimit2() {
        val orderSum = 160_000
        var lastSum = 0
        var card = "VK Pay"
        val result = limit(card, orderSum, lastSum)
        assertEquals(false, result)
    }
    @Test
    fun VKinLimit() {
        val orderSum = 1000
        var lastSum = 0
        var card = "VK Pay"
        val result = limit(card, orderSum, lastSum)
        assertEquals(true, result)
    }
    @Test
    fun OthtercardOverLimit() {
        val orderSum = 600_000
        var lastSum = 160_000
        var card = "Mastercard"
        val result = limit(card, orderSum, lastSum)
        assertEquals(true, result)
    }
    @Test
    fun OthtercardOverLimit2() {
        val orderSum = 1000
        var lastSum = 50_000
        var card = "Maestro"
        val result = limit(card, orderSum, lastSum)
        assertEquals(true, result)
    }
    @Test
    fun OthtercardInLimit() {
        val orderSum = 1000
        var lastSum = 0
        var card = "Мир"
        val result = limit(card, orderSum, lastSum)
        assertEquals(true, result)
    }
@Test
fun cardTypeVK(){
    val orderSum = 999;
    var lastSum = 0
    var card = "VK Pay"
    val result = cardType(card, orderSum, lastSum)
    assertEquals(0, result)
}
    @Test
    fun cardTypeMasAndMaeAndlim(){
        val orderSum = 1000;
        var lastSum = 80_000
        var card = "Mastercard"
        val result = cardType(card, orderSum, lastSum)
        assertEquals(4880, result)
    }
    @Test
    fun cardTypeMasAndMae(){
        val orderSum = 1000;
        var lastSum = 0
        var card = "Mastercard"
        val result = cardType(card, orderSum, lastSum)
        assertEquals(0, result)
    }
    @Test
    fun cardTypeVisaAndMir(){
        val orderSum = 10;
        var lastSum = 0
        var card = "Visa"
        val result = cardType(card, orderSum, lastSum)
        assertEquals(35, result)
    }
    @Test
    fun cardTypeVisaAndMirOverLim(){
        val orderSum = 1000000_000;
        var lastSum = 0
        var card = "Мир"
        val result = cardType(card, orderSum, lastSum)
        assertEquals(35, result)
    }
    @Test
    fun pay(){
        val orderSum = 10000;
        var lastSum = 0
        var card = "VKPay"
        val result = pay(card, orderSum, lastSum)
        assertEquals("Комиссия не взымается", result)
    }
    @Test
    fun pay2(){
        val orderSum = 10000;
        var lastSum = 0
        var card = "Мир"
        val result = pay(card, orderSum, lastSum)
        assertEquals("Комиссия составит 35 рублей", result)
    }
    @Test
    fun pay3(){
        val orderSum = 1000000;
        var lastSum = 10000
        var card = "Мир"
        val result = pay(card, orderSum, lastSum)
        assertEquals("Превышен лимит", result)
    }
}
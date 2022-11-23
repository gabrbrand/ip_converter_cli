import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MainKtTest {
    @Test
    @DisplayName("Convert a decimal to binary number")
    fun testConvertingToBinaryNumber() {
        assertEquals(1010, convertToBinaryNumber(10).toInt())
        assertEquals(11000000, convertToBinaryNumber(192).toInt())
        assertEquals(1010101, convertToBinaryNumber(85).toInt())
    }

    @Test
    @DisplayName("Convert a decimal to binary ip address")
    fun testConvertingToBinaryIpAddress() {
        assertEquals("11000000.10100010.01010101.10011000", convertToBinaryIpAddress("192.162.85.152"))
        assertEquals("00001010.00001111.00001000.00000011", convertToBinaryIpAddress("10.15.8.3"))
        assertEquals("11111111.11111111.11111111.00000000", convertToBinaryIpAddress("255.255.255.0"))
    }
}
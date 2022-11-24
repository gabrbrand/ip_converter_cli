import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MainKtTest {
    @Test
    @DisplayName("Convert a decimal to a binary IP address")
    fun testConvertToBinaryIpAddress() {
        assertEquals("11000000.10100010.01010101.10011000", convertToBinaryIPAddress("192.162.85.152"))
        assertEquals("00001010.00001111.00001000.00000011", convertToBinaryIPAddress("10.15.8.3"))
        assertEquals("11111111.11111111.11111111.00000000", convertToBinaryIPAddress("255.255.255.0"))
    }

    @Test
    @DisplayName("Convert a binary to a decimal IP address")
    fun testConvertToDecimalIPAddress() {
        assertEquals("192.162.85.152", convertToDecimalIPAddress("11000000.10100010.01010101.10011000"))
        assertEquals("10.15.8.3", convertToDecimalIPAddress("00001010.00001111.00001000.00000011"))
        assertEquals("255.255.255.0", convertToDecimalIPAddress("11111111.11111111.11111111.00000000"))
    }
}
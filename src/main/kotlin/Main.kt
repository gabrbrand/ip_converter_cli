fun main() {
    print("Enter a decimal ip address: ")
    val decimalIpAddress = readln()
    val binaryIpAddress = convertToBinaryIpAddress(decimalIpAddress)
    print("Binary ip address: $binaryIpAddress")
}

/**
 * Converts a decimal to a binary ip address
 *
 * @param decimalIpAddress Ip address in decimal format
 * @return Ip address in binary format
 */
fun convertToBinaryIpAddress(decimalIpAddress: String): String {

    // Save each octet of the ip address to a list
    val octets = decimalIpAddress.split(".")
    val result = octets.toMutableList()

    // Replace each decimal octet with a binary one
    for (i in octets.indices) {
        result[i] = convertToBinaryNumber(octets[i].toInt())
    }

    return result.joinToString(".")
}

/**
 * Converts a given decimal to a binary number
 *
 * @param decimalNumber Number in decimal format
 * @return Binary number of decimal number (with leading zeros to get an octet)
 */
fun convertToBinaryNumber(decimalNumber: Int): String {
    var currentQuotient = decimalNumber / 2
    var currentRemainder = decimalNumber % 2
    val result = MutableList(8) { 0 }
    result[result.lastIndex] = currentRemainder

    for (i in result.lastIndex - 1 downTo 0) {
        if (currentQuotient != 0) {
            currentRemainder = currentQuotient % 2
            currentQuotient /= 2
            result[i] = currentRemainder
        } else {
            break
        }
    }

    return result.joinToString("")
}
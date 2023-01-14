import java.lang.Integer.toBinaryString

val validDecimalFormat = Regex("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}") // e.g. 192.168.178.23
val validBinaryFormat = Regex("[01]{8}\\.[01]{8}\\.[01]{8}\\.[01]{8}") // e.g. 11000000.10101000.10110010.00010111

fun main() {
    do {
        convertIpAddress()

        println("\u001B[34mConvert another IP address? Yes (1) No (Any other number)\u001B[0m")
        val answer = getAnswer()

        if (answer != 1) println("\u001B[33mThank you for using IP Converter!\u001B[0m")
    } while (answer == 1)
}

fun getAnswer(): Int {
    var answer: String
    do {
        answer = readln()
        if (!isValidAnswer(answer)) println("\u001B[31mEnter a (positive) integer number!\u001B[0m")
    } while (!isValidAnswer(answer))
    return answer.toInt()
}

fun isValidAnswer(answer: String): Boolean = answer.all { it.isDigit() } && answer.isNotEmpty()

fun getIpAddress(type: String): String {
    var ipAddress: String
    do {
        ipAddress = readln()
        if (!isValidIpAddress(ipAddress, type)) println("\u001B[31mEnter a valid IP address!\u001B[0m")
    } while (!isValidIpAddress(ipAddress, type))
    return ipAddress
}

fun isValidIpAddress(ipAddress: String, type: String): Boolean = when (type) {
    "decimal" -> validDecimalFormat.matches(ipAddress)
    "binary" -> validBinaryFormat.matches(ipAddress)
    else -> false // The passed type doesn't exist
}

fun convertIpAddress() {
    println("\u001B[34mConvert IP address to binary (1) or decimal (2)?\u001B[0m")

    do {
        val answer = getAnswer()
        when (answer) {
            1 -> {
                println("\u001B[33mEnter a decimal IP address:\u001B[0m")
                val decimalIpAddress = getIpAddress("decimal")

                val binaryIpAddress = convertToBinaryIpAddress(decimalIpAddress)

                println("\u001B[32mBinary IP address:\n\u001B[0m\u001B[92m$binaryIpAddress\u001b[0m")
            }

            2 -> {
                println("\u001B[33mEnter a binary IP address:\u001B[0m")
                val binaryIpAddress = getIpAddress("binary")

                val decimalIpAddress = convertToDecimalIpAddress(binaryIpAddress)

                println("\u001B[32mDecimal IP address:\n\u001B[0m\u001B[92m$decimalIpAddress\u001B[0m")
            }

            else -> println("\u001B[31mEnter a valid number (1 or 2)!\u001B[0m")
        }
    } while (answer !in listOf(1, 2))
}

/**
 * Converts a decimal to a binary IP address
 *
 * @param decimalIpAddress IP address in decimal format
 * @return IP address in binary format
 */
fun convertToBinaryIpAddress(decimalIpAddress: String): String {
    // Save each octet of the IP address to a list
    val octets = decimalIpAddress.split(".")
    val result = octets.toMutableList()

    // Replace each decimal octet with a binary one
    for (i in octets.indices) {
        result[i] = toBinaryString(octets[i].toInt()).padStart(8, '0')
    }

    return result.joinToString(".")
}

/**
 * Converts a binary to a decimal IP address
 *
 * @param binaryIpAddress IP address in binary format
 * @return IP address in decimal format
 */
fun convertToDecimalIpAddress(binaryIpAddress: String): String {
    // Save each octet of the IP address to a list
    val octets = binaryIpAddress.split(".")
    val result = octets.toMutableList()

    // Replace each binary octet with a decimal one
    for (i in octets.indices) {
        result[i] = octets[i].toInt(2).toString()
    }

    return result.joinToString(".")
}
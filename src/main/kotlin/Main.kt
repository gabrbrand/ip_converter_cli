import java.lang.Integer.toBinaryString

fun main() {
    do {
        convertIpAddress()

        println("\u001B[34mConvert another IP address? Yes (1) No (Any other number)\u001B[0m")
        val answer = readln().toInt()

        if (answer != 1) println("\u001B[33mThank you for using IP Converter!\u001B[0m")
    } while (answer == 1)
}

fun convertIpAddress() {
    println("\u001B[34mConvert IP address to binary (1) or decimal (2)?\u001B[0m")

    do {
        val answer = readln().toInt()
        when (answer) {
            1 -> {
                println("\u001B[33mEnter a decimal IP address:\u001B[0m")
                val decimalIpAddress = readln()

                val binaryIpAddress = convertToBinaryIpAddress(decimalIpAddress)

                println("\u001B[32mBinary IP address:\n\u001B[0m\u001B[92m$binaryIpAddress\u001b[0m")
            }

            2 -> {
                println("\u001B[33mEnter a binary IP address:\u001B[0m")
                val binaryIpAddress = readln()

                val decimalIpAddress = convertToDecimalIpAddress(binaryIpAddress)

                println("\u001B[32mDecimal IP address:\n\u001B[0m\u001B[92m$decimalIpAddress\u001B[0m")
            }

            else -> println("\u001B[31mEnter a valid number!\u001B[0m")
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
import java.lang.Integer.toBinaryString

val validDecimalCharacters = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.')
val validBinaryCharacters = listOf('0', '1', '.')

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
        checkAnswer(answer)
    } while (!isValidAnswer(answer))
    return answer.toInt()
}

fun checkAnswer(answer: String) {
    if (!answer.all { it.isDigit() }) {
        println("\u001B[31mThe entered answer isn't a number!\u001B[0m")
    }
}

fun isValidAnswer(answer: String): Boolean = answer.all { ch -> ch.isDigit() }

fun getIpAddress(type: String): String {
    var ipAddress: String
    do {
        ipAddress = readln()
        checkIpAddress(ipAddress, type)
    } while (!isValidIpAddress(ipAddress, type))
    return ipAddress
}

fun checkIpAddress(ipAddress: String, type: String) {
    when (type) {
        "decimal" -> {
            if (!ipAddress.all { it in validDecimalCharacters }) {
                val invalidDecimalCharacters = ipAddress.filter { ch -> ch !in validDecimalCharacters }
                println(
                    "\u001B[31mThe entered IP address contains invalid characters (${
                        invalidDecimalCharacters.toList().joinToString()
                    })!\u001B[0m"
                )
            }
        }

        "binary" -> {
            if (!ipAddress.all { it in validBinaryCharacters }) {
                val invalidBinaryCharacters = ipAddress.filter { ch -> ch !in validBinaryCharacters }
                println(
                    "\u001B[31mThe entered IP address contains invalid characters (${
                        invalidBinaryCharacters.toList().joinToString()
                    })!\u001B[0m"
                )
            }
        }
    }
}

fun isValidIpAddress(ipAddress: String, type: String): Boolean = when (type) {
    "decimal" -> ipAddress.all { it in validDecimalCharacters }
    "binary" -> ipAddress.all { it in validBinaryCharacters }
    else -> false
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
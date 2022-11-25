import java.lang.Integer.toBinaryString

fun main() {
    do {
        convertIPAddress()
        println("Convert another IP address? Yes (1) No (Any other number)")
        val answer = readln().toInt()
    } while (answer == 1)
}

fun convertIPAddress() {
    println("Convert IP address to binary (1) or decimal (2)?")

    do {
        val answer = readln().toInt()
        when (answer) {
            1 -> {
                println("Enter a decimal IP address:")
                val decimalIPAddress = readln()
                val binaryIPAddress = convertToBinaryIPAddress(decimalIPAddress)
                println("Binary IP address:\n$binaryIPAddress")
            }

            2 -> {
                println("Enter a binary IP address:")
                val binaryIPAddress = readln()
                val decimalIPAddress = convertToDecimalIPAddress(binaryIPAddress)
                println("Decimal IP address:\n$decimalIPAddress")
            }

            else -> println("Enter a valid number!")
        }
    } while (answer !in listOf(1, 2))
}

/**
 * Converts a decimal to a binary IP address
 *
 * @param decimalIPAddress IP address in decimal format
 * @return IP address in binary format
 */
fun convertToBinaryIPAddress(decimalIPAddress: String): String {
    // Save each octet of the IP address to a list
    val octets = decimalIPAddress.split(".")
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
 * @param binaryIPAddress IP address in binary format
 * @return IP address in decimal format
 */
fun convertToDecimalIPAddress(binaryIPAddress: String): String {
    // Save each octet of the IP address to a list
    val octets = binaryIPAddress.split(".")
    val result = octets.toMutableList()

    // Replace each binary octet with a decimal one
    for (i in octets.indices) {
        result[i] = octets[i].toInt(2).toString()
    }

    return result.joinToString(".")
}
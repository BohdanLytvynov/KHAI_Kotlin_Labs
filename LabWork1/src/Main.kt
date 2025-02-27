import kotlin.math.*

//Литвинов Богдан Юрійович Вар 48 формула; x+2.0/3/x*a+sqrt(sin(x))/2/ln(x)+1.0e-3*(x/7).pow(2.0/3)
fun main() {

    println("Lab Work 1");
    var xStart: Int = InputInt("Enter the start value for the x variable:")
    var xEnd: Int = InputInt("Enter the end value for the x variable:");

    if (xEnd < xStart) {
        xEnd = xStart.also { xStart = xEnd }
        println("The start value was greater then end value! We will perform SWAP operation!")
        println("Now: Start: ${xStart}, End: ${xEnd}...");
    }

    println("Generating the a - coeficient....")
    val a = (1..10).random();
    println("Generating done... \na = ${a}")

    val StepsCount: Int = (xEnd - xStart);
    val step: Double = (StepsCount.toDouble() / 100)
    println("Steps: $StepsCount")
    println("Diff: $step")
    var x: Double = 0.0;//x value
    var i: Int = 0;

    val table: Array<Array<Double>> = Array(StepsCount + 1, { Array(2, { Double.NaN }) })

    do {
        val res: Double = Calculate(x, a);
        table[i][0] = x;
        if (!res.isNaN() && !res.isInfinite()) {
            table[i][1] = res;
        }
        x += step;
        ++i;
    } while (x <= StepsCount)

    PrintArray(table)

    println("Finished!");
}

fun Calculate(x: Double, a: Int): Double =
    x + 2.0 / 3 / x * a + sqrt(sin(x)) / 2 / ln(x) + 1.0e-3 * (x / 7).pow(2.0 / 3);

fun PrintArray(table: Array<Array<Double>>) {
    for (row in table) {
        for (cell in row) {
            print(" ${String.format("%.3f", cell)} ")
        }
        println()
    }

}

fun InputInt(msg: String): Int {
    var res: Int = 0

    do {
        println(msg)
        var str: String? = readln()
        try {
            res = str!!.toInt()
            println("You have entered: ${res}")
            break;
        } catch (e: Exception) {
            println("Error: ${e.message} cause of ${e.cause}! Please try again!")
        }

    } while (true)

    return res;
}

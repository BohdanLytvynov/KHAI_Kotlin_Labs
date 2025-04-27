


import kotlin.math.PI
import kotlin.math.sqrt
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun HasRoom(dwelling : Dwelling) : Boolean {
    var res : Boolean = dwelling.hasRoom()
    println("Has Room?: ${res}")
    return res
}

fun main() {
    println("Lab Work 4")
    val square = SquareCabin(5)
    square.printInfo()
    val hunt = RoundHunt(5);
    hunt.printInfo()
    val rTower = RoundTower(5);
    rTower.printInfo()

    if(HasRoom(square))
    {
        square.getRoom()
        square.printInfo()
    }
}

abstract class  Dwelling(private var residents : Int){
    abstract val buildingMaterial : String
    abstract val capacity : Int
    abstract  fun floorArea() : Double
    fun hasRoom() : Boolean{
        return residents < capacity
    }

    open fun printInfo() {
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }

    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }


}

class SquareCabin(residents : Int, val length : Double = 2.0)  : Dwelling(residents) {
    override val buildingMaterial: String = "Wood"

    override val capacity: Int = 6;

    override fun printInfo() {
        println("\nSquare Cabin\n============")
        super.printInfo()
    }

    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHunt(residents : Int, val radius : Double = 3.0) : Dwelling(residents) {
    override val capacity: Int = 4;
    override val buildingMaterial: String = "Straw"
    override fun printInfo() {
        println("\nRound Hunt\n============")
        super.printInfo()
    }

    override fun floorArea(): Double {
        return radius * radius * PI
    }

    fun calculateMaxCarpetSize(): Double = sqrt(2 * radius  * radius)

}

class RoundTower(residents : Int,
                 val floors : Int = 2)
    : RoundHunt(residents) {
    override val capacity: Int = 4 * floors;
    override val buildingMaterial: String = "Stone"
    override fun printInfo() {
        println("\nRound Tower\n============")
        super.printInfo()
    }

    override fun floorArea(): Double {
        return super.floorArea() * floors;
    }
}
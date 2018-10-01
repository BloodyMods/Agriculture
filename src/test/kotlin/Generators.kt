import atm.bloodworkxgaming.agriculture.items.food.FoodItems
import java.io.File
import java.io.PrintWriter


fun renameItems() {
    var files = File("D:\\Users\\jonas\\Documents\\GitHub\\Agriculture\\src\\main\\resources\\assets\\agriculture\\textures\\items").listFiles()
    files.filter { it.isFile && it.toString().endsWith(".png") }.forEach {
        var n = it.nameWithoutExtension
        val b = StringBuilder()
        n.forEach {
            if (it.isUpperCase())
                b.append("_")

            b.append(it.toLowerCase())
        }

        it.renameTo(File(it.parentFile, b.substring(1) + ".png"))
    }
}

fun listFiles() {
    var files = File("D:\\Users\\jonas\\Documents\\GitHub\\Agriculture\\src\\main\\resources\\assets\\agriculture\\textures\\items").listFiles()
    files.filter { it.isFile && it.toString().endsWith(".png") }.forEach {
        println(it.nameWithoutExtension)
    }
}

fun createJsons() {
    val base = File("D:\\Users\\jonas\\Documents\\GitHub\\Agriculture\\src\\main\\resources\\assets\\agriculture\\models\\item")

    for (value in FoodItems.values()) {
        PrintWriter(File(base, value.name.toLowerCase() + ".json")).use {
            it.println("""
            {
                "parent": "item/handheld",
                "textures": {
                    "layer0": "agriculture:items/${value.name.toLowerCase()}"
                }
            }
            """.trimIndent())
        }
    }
}


fun main(args: Array<String>) {
    createJsons()
}
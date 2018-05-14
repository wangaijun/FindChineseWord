data class HardCodeInfo(val fileName:String,val lineNum:Int,val word:String){
}

fun main(args: Array<String>) {
    val hci = HardCodeInfo("A.java",88,"质量")
    println(hci.toString())
}
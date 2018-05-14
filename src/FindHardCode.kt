import java.io.File
import java.util.regex.Pattern

val fileName = "/home/waj/dev/android_pro/android/bim5d/main_as/bIM5D/src/main/java/com/glodon/bim5d2/weektask/activity/OutputDateListWebActivity.java"

fun findHardCode(f: File, hardCodeList:ArrayList<HardCodeInfo>){
    val ss =f.readLines()
    var i = 0
    ss.forEach{
        i++
        isChinese(it)?.let {ret->
            hardCodeList.add(HardCodeInfo(f.name,i,ret))
        }
    }
}

fun isChinese(str: String): String? {
    val regEx = "\"([\u4e00-\u9fa5]+)"
    val pat = Pattern.compile(regEx)
    val matcher = pat.matcher(str)
    var str:String? = null
    if (matcher.find()) {
        str = matcher.group(1)
    }
    return str
}

fun main(args: Array<String>) {
    val list = arrayListOf<HardCodeInfo>()
    findHardCode(File(fileName),list)
    list.forEach{
        println(it.toString())
    }
    println(list.size)
}
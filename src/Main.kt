import java.io.File

fun main(args: Array<String>) {
    val files = arrayListOf<File>()
    listFile(File(dir1),files)
    listFile(File(dir2),files)
    val codes = arrayListOf<HardCodeInfo>()
    files.forEach{
        findHardCode(it,codes)
    }
    var fname:String? = null
    codes.forEach{
        if (it.fileName!=fname){
            fname = it.fileName
            println(fname)
        }
        println("\t${it.lineNum},${it.word}")
    }
    println(codes.size)


}
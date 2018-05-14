import java.io.File

fun listFile(file:File,subFiles:ArrayList<File>){
    if (!file.exists()) return
    if (file.isFile) {
        subFiles.add(file)
    }
    else if(file.isDirectory){
        val fs = file.listFiles()
        fs.forEach {
            listFile(it,subFiles)
        }
    }
}

val dir1 = "/home/waj/dev/android_pro/android/bim5d/main_as/bIM5D/src/main/java/com/glodon/bim5d2/weektask"
val dir2 = "/home/waj/dev/android_pro/android/bim5d/main_as/bIM5D/src/main/res/layout"
fun main(args: Array<String>) {
    val files = arrayListOf<File>()
    listFile(File(dir2),files)
    files.forEach{
        println(it.name)
    }
    println(files.count())
}
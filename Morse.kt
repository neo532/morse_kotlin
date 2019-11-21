﻿/*
 * 莫斯密码转化
 * @author liuxiaofeng
 * @date 2019-11-20
 * @mail neo532@126.com
 */
interface CodeConverter{
    public fun encrypt(oriChar: String):String
    public fun decrypt(oriChar: String):String
}

object MorseConverter : CodeConverter{
    private val char2morseList:Map<String,String>
    private val morse2charList:Map<String,String>
    private const val delimiter = "/"
    private const val di = "•"
    private const val da = "ㅡ"

    init{
        //这里顺序不能更改
        this.char2morseList = getChar2mouseList()
        this.morse2charList = getMorse2charList()
    }

    override fun encrypt(oriChar: String):String{
        return char2morse(oriChar)
    }

    override fun decrypt(oriChar: String):String{
        return morse2char(oriChar)
    }

    internal fun morse2char(oriMorse: String):String {
        val morse2charList = this.morse2charList
        var letterList = oriMorse.split(delimiter)

        var word = ""
        var tmp:String?

        for (letter in letterList) {
            tmp = morse2charList.get(letter.toString())
            if(tmp==null){
                word += letter
            }else{
                word += tmp.toString()
            }
        }

        return word
    }

    internal fun char2morse(oriChar: String):String {
        val char2morseList = this.char2morseList

        var tmp:String?
        var morse = ""

        for (letter in oriChar) {
            tmp = char2morseList.get(letter.toString())
            if(tmp==null){
                morse += letter.toString()
            }else{
                morse += tmp.toString()
            }
            morse += delimiter
        }
        morse = morse.dropLast(1)

        return morse
    }

    private fun getMorse2charList() :Map<String,String> {
        val char2morseList = this.char2morseList
        var morse2charList= mapOf<String,String>().toMutableMap()
        for ((k,v) in char2morseList){
            morse2charList[v] = k
        }
        return morse2charList
    }

    private fun getChar2mouseList() :Map<String,String>{
        return mapOf(
            "a" to di + da,
            "b" to da + di + di + di,
            "c" to da + di + da + di,
            "d" to da + di + di,
            "e" to di,
            "f" to di + di + da + di,
            "g" to da + da + di,
            "h" to di + di + di + di,
            "i" to di + di,
            "j" to di + da + da + da,
            "k" to da + di + da,
            "l" to di + da + di + di,
            "m" to da + da,
            "n" to da + di,
            "o" to da + da + da,
            "p" to di + da + da + di,
            "q" to da + da + di + da,
            "r" to di + da + di,
            "s" to di + di + di,
            "t" to da,
            "u" to di + di + da,
            "v" to di + di + di + da,
            "w" to di + da + da,
            "x" to da + di + di + da,
            "y" to da + di + da + da,
            "z" to da + da + di + di,
            "0" to da + da + da + da + da,
            "1" to di + da + da + da + da,
            "2" to di + di + da + da + da,
            "3" to di + di + di + da + da,
            "4" to di + di + di + di + da,
            "5" to di + di + di + di + di,
            "6" to da + di + di + di + di,
            "7" to da + da + di + di + di,
            "8" to da + da + da + di + di,
            "9" to da + da + da + da + di
        )
    }
}

package com.anhquan.keywordsample.util

object StringUtil {
    /**
     * Format the input string, if the string is more than one word, then display in two balanced lines
     * @param keyword The input string
     * @return The formatted string
     */
    fun getTextAfterAlign(keyword: String): String {
        val finalString: String
        val midCharIndex = keyword.length / 2
        // find the closest space character to the left of the mid character of the string
        val preIndex = keyword.lastIndexOf(" ", midCharIndex, true)
        // find the closest space character to the right of the mid character of the string
        val sufIndex = keyword.indexOf(" ", midCharIndex + 1, true)

        finalString = if (preIndex == -1 && sufIndex == -1) { // keyword only contains one word
            keyword
        }
        else if (preIndex != -1 && sufIndex == -1) {  // there is not any space character to the right, but to the left
            keyword.substring(0, preIndex) + "\n" + keyword.substring(preIndex, keyword.length)
        }
        else if (preIndex == -1 && sufIndex != -1) { // there is not any space character to the left, but to the right
            keyword.substring(0, sufIndex) + "\n" + keyword.substring(sufIndex, keyword.length)
        }
        else if (midCharIndex - preIndex > sufIndex - midCharIndex) {
            // we do have both space to the left and right of the mid character, get the left one because its nearer
            keyword.substring(0, sufIndex) + "\n" + keyword.substring(sufIndex, keyword.length) //
        }
        else { // get the right one
            keyword.substring(0, preIndex) + "\n" + keyword.substring(preIndex, keyword.length)
        }

        return finalString
    }
}
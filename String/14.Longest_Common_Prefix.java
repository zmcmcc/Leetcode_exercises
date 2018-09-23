/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0){// Example "abcd".indexOf("ab") == 0; "abcd".indexOf("bcd") == 1;"abcd".indexOf("abcde") != 0
                res = res.substring(0,res.length()-1);// cut the last char of res and check again
            }
        }
    return res;
    }
}

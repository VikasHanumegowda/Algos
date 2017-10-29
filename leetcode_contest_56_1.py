'''
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.

Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.

Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.

Note:

    All characters have an ASCII value in [35, 126].
    1 <= len(chars) <= 1000.

'''
class Solution(object):
    def compress(self, chars):
        """
        :type chars: List[str]
        :rtype: int
        """
        l = len(chars)
        if l == 1:
            return l
        x = 0
        naming_pos = 0
        count = 1
        have_to_be_named = 0
        while x < len(chars) - 1:
            charr = chars[x]
            if chars[x] == chars[x + 1]:
                if have_to_be_named == 0:
                    chars[naming_pos] = charr
                    naming_pos += 1
                    have_to_be_named = 1
                count += 1
            else:
                if count != 1:
                    chars[naming_pos] = count
                    naming_pos += 1
                else:
                    chars[naming_pos] = charr
                    naming_pos += 1
                count = 1
                have_to_be_named = 0
            x += 1
        if count != 1:
            chars[naming_pos] = count
        else:
            if type(chars[naming_pos - 1]) == str:
                if chars[naming_pos - 1] != charr:
                    chars[naming_pos] = charr
                else:
                    chars[naming_pos] = chars[x]
            else:
                chars[naming_pos] = chars[x]
        del chars[naming_pos + 1:]

        for y, x in enumerate(chars):
            if type(x) == int:
                if x > 9:
                    temp = x
                    del chars[y]
                    chars.insert(y, str(int(temp / 10)))
                    chars.insert(y+1, str(temp % 10))
                else:
                    temp = x
                    del chars[y]
                    chars.insert(y, str(temp))
        print(chars)

        return len(chars)


print(Solution().compress(["a","a","b","b","c","c","c"]))
# print(Solution().compress(["a","a","a","a","a","a","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","c","c","c","c","c","c","c","c","c","c","c","c","c","c"]))

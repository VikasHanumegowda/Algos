'''
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.

spoilers alert... click to show requirements for atoi.
Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.


'''
class Solution:
    def myAtoi(self, str_s):
        """
        :type str: str
        :rtype: int
        """
        num = 0
        
        str_s= str_s.strip()
        
        sign = 1
        i = 0
        l = len(str_s)
        if l == 0:
            return 0
        
        if str_s[0] == '-':
            sign = -1
            str_s = str_s[1:]
        elif str_s[0] == '+':
            sign = 1
            str_s = str_s[1:]
        else:
            sign = 1
        
        l = len(str_s)
        maxnum = 2**31 - 1
        # print(maxnum)
        while i < l and str_s[i] >='0' and str_s[i] <= '9' :
            if sign == 1 : 
                if num == int(maxnum/10) and ord(str_s[i]) - ord('0') > 7 or num > int(maxnum/10):
                    return maxnum
            else:
                if num == int(maxnum/10) and ord(str_s[i]) - ord('0')  > 8 or num > int(maxnum/10):
                    return -maxnum-1
            num = num * 10 + ord(str_s[i]) -ord('0') 
            i += 1
        return num * sign

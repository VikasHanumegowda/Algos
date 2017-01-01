# Complete the function below.

def check_palindrome(str):
    str_rev = str[::-1]
    print(str+" "+str_rev)
    if str_rev == str:
        print("True")
        return True
    return False


def palindrome(str):
    # print("alknfskdnflskdnvlksn")
    count = 0
    al_list = [str[i:j + 1] for i in range(len(str)) for j in range(i, len(str))]
    a1_list=set(al_list)
    print(a1_list)
    a_list=list(a1_list)
    print(a_list)
    for i in range(len(a_list)):
        if check_palindrome(a_list[i]):
            count = count + 1
            print(count)
        else:
            continue
    return count


print(palindrome("aabaa"))
import re

n=int(input())
pattern=r"(#[a-fA-F0-9]{3,6})[;,)]"
for i in range(n):
    str=input()
    match=re.findall(pattern,str)
    if match:
        for x in match:
            print(x)
def longestCommonPrefix( strs):
    """
    :type strs: List[str]
    :rtype: str
    """
    l = len(strs)
    if l == 0:
        return ""
    pre = strs[0]

    for x in range(1, len(strs)):
        if strs[x].startswith(pre):
            continue
        else:
           while not strs[x].startswith(pre):
               pre = pre[:-1]
    return pre

print(longestCommonPrefix(["hyello","hell","hello"]))
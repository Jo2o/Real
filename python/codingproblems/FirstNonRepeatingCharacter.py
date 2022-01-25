def findFirstNonRepeating(str):
    for c in str:
        if str.index(c) == str.rindex(c):
            return c
    return "_"


print(findFirstNonRepeating("kva-kva-r"))

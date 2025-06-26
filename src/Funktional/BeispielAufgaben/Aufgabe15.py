from functools import reduce

# Funktional
l = ["Apfel", "Banane"]

def cl(word):
    return word.lower().count("a".lower())

def s(x, y):
    return x + y

print(reduce(s, map(cl, l)))

# Lambda
l = ["Apfel", "Banane"]

print(reduce(lambda x, y: x + y, map(lambda word: word.lower().count("a".lower()), l)))

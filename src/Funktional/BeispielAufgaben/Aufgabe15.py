from functools import reduce

# Funktional
l = ["Apfel", "Banane"]

def cl(x):
    return x.lower().count("a".lower())

def s(x, y):
    return x + y

print(reduce(s, map(cl, l)))

# Lambda
l = ["Apfel", "Banane"]

print(reduce(lambda x, y: x + y, map(lambda x: x.lower().count("a".lower()), l)))
# Funktional
l = ["Apfel", "Ei", "Hund"]

def length(x):
    return len(x)

print(list(map(length, l)))

# Lambda
l = ["Apfel", "Ei", "Hund"]

print(list(map(lambda x: len(x), l)))
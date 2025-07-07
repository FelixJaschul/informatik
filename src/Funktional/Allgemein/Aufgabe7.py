# Funktional
l = ["Apfel", "Banane"]

def g(x):
    return x.upper()

print(list(map(g, l)))

# Lambda
l = ["Apfel", "Banane"]

print(list(map(lambda x: x.upper(), l)))
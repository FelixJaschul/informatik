# Funktional
l = ["Apfel", "Auto", "Haus", "Affe"]

def a(x):
    return x[0] == "A"

print(list(filter(a, l)))

# Lambda
l = ["Apfel", "Auto", "Haus", "Affe"]

print(list(filter(lambda x: x[0] == "A", l)))
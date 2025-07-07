# Funktional
l = ["Apfel", "Haus", "Mango"]

def b(x):
    return len(x) == 5

print(list(filter(b, l)))

# Lambda
l = ["Apfel", "Haus", "Mango"]

print(list(filter(lambda x: len(x) == 5, l)))

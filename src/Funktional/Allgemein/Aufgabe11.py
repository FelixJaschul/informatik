# Funktional
l = ["Haus", "Baum1", "Fluss", "123", "See!"]

def o(x):
    return x.isalpha()

print(list(filter(o, l)))

# Lambda
l = ["Haus", "Baum1", "Fluss", "123", "See!"]

print(list(filter(lambda x: x.isalpha(), l)))
# Funktional
l = [1, 2, 3, 4, 5]

def g(x) -> bool:
    return x % 2 == 0

print(list(filter(g, l)))

# Lambda
l = [1, 2, 3, 4, 5]

print(list(filter(lambda x: x % 2 == 0, l)))
from functools import reduce

# Funktional
l = [1, 2, 3, 4, 5]

def o(x):
    return x % 2 != 0

def m(x, y):
    return x * y

print(reduce(m, filter(o, l)))

# Lambda
l = [1, 2, 3, 4, 5]

print(reduce(lambda x, y: x * y, filter(lambda x: x % 2 != 0, l)))
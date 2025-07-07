from functools import reduce

# Funktional
l = [2, 4, 6]

def s(x, y):
    return x + y

def a(numbers):
    total = reduce(s, numbers)
    return total / len(numbers)

print(a(l))

# Lambda
l = [2, 4, 6]

print(reduce(lambda x, y: x + y, l) / len(l))
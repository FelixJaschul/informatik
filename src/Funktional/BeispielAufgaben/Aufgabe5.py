from functools import reduce

# Funktional
l = [1, 2, 3, 4]

def s(x, y):
    return x + y

print(reduce(s, l))

# Lambda
l = [1, 2, 3, 4]

print(reduce(lambda x, y: x + y, l))
# Funktional
l = [1, 2, 3, 4]

def q(x):
    return x % 2 == 0

def s(x):
    return x * x

print(list(map(s, filter(q, l))))

# Lambda
l = [1, 2, 3, 4]

print(list(map(lambda x: x * x, filter(lambda x: x % 2 == 0, l))))
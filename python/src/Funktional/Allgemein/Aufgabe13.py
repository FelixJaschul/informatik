# Funktional
l = [5, 12, 20]

def t(x):
    return x > 10

print(list(map(t, l)))

# Lambda
l = [5, 12, 20]

print(list(map(lambda x: x > 10, l)))
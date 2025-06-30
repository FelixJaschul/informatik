# Imperative
l = [1, 2, 3, 4]
for i in range(len(l)):
    l[i] = l[i] * l[i]

print(l)

# Funktional
l = [1, 2, 3, 4]
def q(x):
    return x * x

print(list(
        map(q, l)
    ))

# Lambda
l = [1, 2, 3, 4]

print(list(
        map(lambda x: x * x, l)
    ))
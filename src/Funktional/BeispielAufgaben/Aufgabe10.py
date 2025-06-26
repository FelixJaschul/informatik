from functools import reduce

# Funktional
l = ["Hund", "Katze", "Elefant"]

def w(x, y):
    if len(x) >= len(y):
        return x
    else:
        return y

print(reduce(w, l))

# Lambda
l = ["Hund", "Katze", "Elefant"]

print(reduce(lambda x, y: x if len(x) >= len(y) else y, l))
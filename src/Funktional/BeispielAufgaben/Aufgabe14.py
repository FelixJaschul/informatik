# Funktional
l = ["Haus", "Katze", "Ei"]

def gl(x):
    return len(x)

print(sorted(l, key=gl))

# Lambda
l = ["Haus", "Katze", "Ei"]

print(sorted(l, key=lambda x: len(x)))
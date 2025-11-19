def v(x: int):
    if x > 1e3: return []
    else: return [x] + v(x + 7)

# print(v(0))

a = (lambda f: f(f)) (lambda f: lambda x: [] if x > 1e3 else [x] + f(f)(x+7))
# print(a(0))

l: list = []
def f(x: int):
    l.append(x)
    if x <= 1: return 1
    return x * f(x - 1)

print(f(9))
print(l)

print(list(map(lambda x: len(x), ("Apfel", "Banane"))))
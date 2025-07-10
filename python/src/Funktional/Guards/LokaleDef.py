def y(x: int) -> int:
    a = x * 2
    b = x ** 2
    return a + b

def r(x: int) -> int:
    def k(g: int) -> int: return g * 2
    def h(z: int) -> int: return z ** 2
    return k(x) + h(x)

print(r(5))
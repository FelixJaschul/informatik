y = 0
while y <= 0.2:
    k = 490.051 + y
    x: float = 330.0 / k

    y = y + 0.001
    print(f"x: {x}  ")
    print(f"k: {k}  ")
    print(f"y: {y}\n")
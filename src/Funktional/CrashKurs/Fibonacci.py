from functools import cache

@cache
def fibonacci(n: int) -> int:
    if n < 2:
        return n
    return fibonacci(n - 2) + fibonacci(n - 1)

print(fibonacci(100))
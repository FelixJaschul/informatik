from functools import reduce

l1 = [-1, 2]
l2 = [-2, 4]

def add(a, b): return list(map(lambda x, y: x + y,  a, b))
def mul(a, b): return list(map(lambda x, y: x * y,  a, b))
def sub(a, b): return list(map(lambda x, y: x - y,  a, b))
def s_m(a, k): return list(map(lambda x: k * x,     a))
def dot(a, b): return reduce(lambda g, e: g + e[0] * e[1], zip(a, b), 0)


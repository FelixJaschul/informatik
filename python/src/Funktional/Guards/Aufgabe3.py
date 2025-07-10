from math import sqrt

def flaeche_quader(l: int, b: int, h: int) -> int:
    return (l * b + b * h + h * l) * 2

def volumen_quader(l: int, b: int, h: int) -> int:
    return l * b * h

def dreieck(a: int, b: int, c: int) -> float:
    s: float = (a + b + c) / 2
    return sqrt(s * (s - a) * (s - b) * (s - c))
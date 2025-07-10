def const_42() -> int:
    return 42

def fuenffaches(x: int) -> int:
    return x * 5

def groesser3(x: int) -> str:
    if x > 3:   return "Ja!"
    else:       return "Nein"

def hitzefrei(t: int) -> bool:
    if t >= 27: return True
    else:       return False

def maximum(x: int, y: int) -> int:
    if y > x:   return y
    else:       return x
def minimum(x: int, y: int) -> int:
    if y < x:   return y
    else:       return x

def betrag(x: int) -> int:
    return abs(x)

def tupelTausch(t: tuple) -> tuple:
    return t[1], t[0]

print(tupelTausch((1, 2)))

def multiAll(t: tuple, n: int) -> tuple:
    return tuple(map(lambda x: x * n, t))

def versetzen(t: tuple) -> tuple | str:
    if t[2] < 12: return t[0], t[1], t[2] + 1 , t[3]
    else: return "Abschluss"

def name(t): return t[0]
def vorname(t): return t[1]
def jahrgang(t): return t[2]
def zug(t): return t[3]

print(versetzen(("A", "B", 11, 1)))
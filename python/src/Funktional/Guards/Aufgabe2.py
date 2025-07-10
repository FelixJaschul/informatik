def warnmail(name: str, geschlecht: str) -> str:
    x: str = "Ihr"
    match geschlecht.lower():
        case "m": x = x + f" Sohn {name} hat keine Hausaufgaben gemacht"
        case "w": x = x + f"e Tocher {name} hat keine Hausaufgaben gemacht"
        case _ : x = f"{name} kann Eier lecken"
    return x

print(warnmail("Lea", "W"))
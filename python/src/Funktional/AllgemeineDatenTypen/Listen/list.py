from functools import reduce

stack = [3, 2, 1]

def push(v, s: list) -> list:
    return [v] + s

def pop(s: list) -> tuple:
    return s[0], s[1:]

def peek(s: list):
    return s[0]

def is_empty(s: list) -> bool:
    return len(s) == 0

def to_string(s: list) -> str:
    return reduce(lambda x, y: f"{str(x)}, {str(y)}", s)

def depth(s: list) -> int:
    return len(s)

def replace_top(v, s: list) -> list:
    if is_empty(s): return s
    _, s_2 = pop(s)
    return push(v, s_2)

def is_palindrome(v: str) -> bool:
    return v.lower() == v[::-1].lower()

def save(value, s: list) -> list:
    return push(value, s)

def back(s: list):
    if is_empty(s): return s
    last, s_2 = pop(s)
    return last, peek(s_2)

save_state =  save("Hallo", [])
save_state =  save("Welt", save_state)
print(save_state)
test, back_state = back(save_state)
print(test)
print(back_state)
print(save_state)

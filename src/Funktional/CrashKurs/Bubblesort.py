import random as rd

# Imperativ
def bubble_sort(arr: list) -> list:
    n = len(arr)
    for i in range(n - 1):
        for j in range(0, n - 1, 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr

data = []
for i in range(1000):
    data.append(rd.randint(0, 1000))

print(bubble_sort(data))

# Funktional
def b(xs):
    if len(xs) < 2:
        return xs, False
    x, y, *ys = xs
    if x > y:
        rest, changed = bubble([x] + ys)
        return [y] + rest, True
    else:
        rest, changed = bubble([y] + ys)
        return [x] + rest, changed

def b_sort(xs):
    result, changed = bubble(xs)
    if changed:
        return bubble_sort(result)
    else:
        return result

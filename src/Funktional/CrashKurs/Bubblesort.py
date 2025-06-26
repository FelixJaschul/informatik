import random as rd

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

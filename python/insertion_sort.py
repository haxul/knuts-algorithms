init_arr = [13, 1, 10, 2, 5, 4]


def insert_sort(arr):
    for j, _ in enumerate(arr):
        key = arr[j]
        i = j - 1
        while i > 0 and arr[i] > key:
            arr[i + 1] = arr[i]
            i = i - 1
        arr[i + 1] = key
    return arr


result = insert_sort(init_arr)
print(result)

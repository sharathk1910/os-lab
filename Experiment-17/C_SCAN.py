def main():
    t = [0] * 20
    d = [0] * 20
    atr = [0] * 20
    sum = 0

    n = int(input("Enter the number of tracks to be traversed: "))
    h = int(input("Enter the position of head: "))
    t[0] = 0
    t[1] = h

    tot = int(input("Enter total tracks: "))
    t[2] = tot - 1

    print("Enter the tracks:")
    for i in range(3, n + 3):
        t[i] = int(input())

    for i in range(n + 3):
        for j in range(n + 3 - i - 1):
            if t[j] > t[j + 1]:
                t[j], t[j + 1] = t[j + 1], t[j]

    for i in range(n + 3):
        if t[i] == h:
            j = i
            break

    p = 0
    while j < n + 3 and t[j] != tot - 1:
        atr[p] = t[j]
        j += 1
        p += 1

    if j < n + 3:
        atr[p] = t[j]
        p += 1

    i = 0
    while p < n + 3 and i < n + 3 and t[i] != h:
        atr[p] = t[i]
        i += 1
        p += 1

    for j in range(n + 2):
        d[j] = abs(atr[j] - atr[j + 1])
        sum += d[j]

    print(f"Total header movements: {sum}")
    print(f"Average header movements: {sum / n}")

if __name__ == "__main__":
    main()

def main():
    t = [0] * 20
    d = [0] * 20
    atr = [0] * 20
    sum = 0

    n = int(input("Enter the number of tracks to be traversed: "))
    h = int(input("Enter the position of head: "))
    t[0] = 0
    t[1] = h

    print("Enter the tracks:")
    for i in range(2, n + 2):
        t[i] = int(input())

    for i in range(n + 2):
        for j in range(n + 2 - i - 1):
            if t[j] > t[j + 1]:
                t[j], t[j + 1] = t[j + 1], t[j]

    for i in range(n + 2):
        if t[i] == h:
            j = i
            k = i
            break

    p = 0
    while t[j] != 0:
        atr[p] = t[j]
        j -= 1
        p += 1

    atr[p] = t[j]
    for p in range(k + 1, n + 2):
        atr[p] = t[k + 1]
        k += 1

    for j in range(n + 1):
        d[j] = abs(atr[j] - atr[j + 1])
        sum += d[j]

    print(f"\nAverage header movements: {sum / n}")

if __name__ == "__main__":
    main()

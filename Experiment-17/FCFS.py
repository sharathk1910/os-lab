def main():
    t = [0] * 20
    tohm = [0] * 20
    tot = 0

    n = int(input("Enter the number of tracks: "))
    print("Enter the tracks to be traversed:")

    for i in range(2, n + 2):
        t[i] = int(input())

    for i in range(1, n + 1):
        tohm[i] = abs(t[i + 1] - t[i])

    for i in range(1, n + 1):
        tot += tohm[i]

    avhm = tot / n

    print("Tracks traversed\tDifference between tracks")
    for i in range(1, n + 1):
        print(f"{t[i]}\t\t\t{tohm[i]}")

    print(f"\nAverage header movements: {avhm}")

if __name__ == "__main__":
    main()

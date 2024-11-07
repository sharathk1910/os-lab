def main():
    buffer = [None] * 10
    bufsize = 10
    in_pos = 0
    out_pos = 0
    choice = 0

    while choice != 3:
        print("\n1. Produce \t 2. Consume \t3. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            if (in_pos + 1) % bufsize == out_pos:
                print("\nBuffer is Full")
            else:
                produce = int(input("Enter the value: "))
                buffer[in_pos] = produce
                in_pos = (in_pos + 1) % bufsize

        elif choice == 2:
            if in_pos == out_pos:
                print("\nBuffer is Empty")
            else:
                consume = buffer[out_pos]
                print(f"\nThe consumed value is {consume}")
                out_pos = (out_pos + 1) % bufsize

if __name__ == "__main__":
    main()

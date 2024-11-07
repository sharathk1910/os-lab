import sys

tph = 0
philname = [0] * 20
status = [0] * 20
howhung = 0
hu = [0] * 20
cho = 0

def main():
    global tph, howhung, cho
    print("\n\nDINING PHILOSOPHER PROBLEM")
    tph = int(input("Enter the total no. of philosophers: "))
    
    for i in range(tph):
        philname[i] = i + 1
        status[i] = 1
    
    howhung = int(input("How many are hungry: "))
    
    if howhung == tph:
        print("\n All are hungry..\nDead lock stage will occur")
        print("\nExiting\n")
        sys.exit(0)
    else:
        for i in range(howhung):
            hu[i] = int(input(f"Enter philosopher {i + 1} position: "))
            status[hu[i]] = 2
        
        while True:
            cho = int(input("1. One can eat at a time\t2. Two can eat at a time\t3. Exit\nEnter your choice: "))
            if cho == 1:
                one()
            elif cho == 2:
                two()
            elif cho == 3:
                sys.exit(0)
            else:
                print("\nInvalid option..")

def one():
    pos = 0
    print("\nAllow one philosopher to eat at any time\n")
    for i in range(howhung):
        print(f"\nP {philname[hu[pos]]} is granted to eat")
        for x in range(pos, howhung):
            print(f"\nP {philname[hu[x]]} is waiting")
        pos += 1

def two():
    s = 0
    print("\nAllow two philosophers to eat at the same time\n")
    for i in range(howhung):
        for j in range(i + 1, howhung):
            if abs(hu[i] - hu[j]) >= 1 and abs(hu[i] - hu[j]) != 4:
                print(f"\n\ncombination {s + 1}")
                t = hu[i]
                r = hu[j]
                s += 1
                print(f"\nP {philname[hu[i]]} and P {philname[hu[j]]} are granted to eat")
                for x in range(howhung):
                    if hu[x] != t and hu[x] != r:
                        print(f"\nP {philname[hu[x]]} is waiting")

if __name__ == "__main__":
    main()


n = int(input())
for i in range(n):
    s = int(input())

    if s <= 1_000_000:
        print("NO")
        break

    isPrime = True
    min = 0

    for j in range(2,1_000_001):
        if s % j == 0:
            isPrime = False
            min = j
            break
    if isPrime or min > 1_000_000:
        print("YES")
    else:
        print("NO")
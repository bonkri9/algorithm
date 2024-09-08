n = int(input())
arr = []
arr_y = []
arr_x = []
ans = [-1] * n

# 입력 받기
for _ in range(n):
    a, b = map(int, input().split())
    arr.append([a, b])
    arr_x.append(a)
    arr_y.append(b)

# 만날 장소 정하기
for y in arr_y:
    for x in arr_x:
        dist = []

        # 만날 장소로 각각의 점들이 오는 비용 계산
        for ex, ey in arr:
            d = abs(ex - x) + abs(ey - y)
            dist.append(d)
        
        # 가까운 순서대로 정렬
        dist.sort()

        tmp = 0
        for i in range(len(dist)):
            d = dist[i]
            tmp += d
            if ans[i] == -1:
                ans[i] = tmp
            else:
                ans[i] = min(tmp, ans[i])

print(*ans)
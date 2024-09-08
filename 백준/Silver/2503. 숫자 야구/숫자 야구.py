n = int(input()) 

hint = [list(map(str, input().split())) for _ in range(n)]
# [123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]
# string을 미리 넣어준 이유는, 나중에 쪼개기 위해서

ans = 0

# 100 ~ 999 까지 조사 
for a in range(1, 10): # 100의 자리수
    for b in range(1, 10): # 10의 자리수
        for c in range(1, 10): # 1의 자리수

            cnt = 0
            if( a == b or b == c or c == a):
                continue

            for arr in hint:
                check = list(arr[0])
                strike = int(arr[1])
                ball = int(arr[2])

                # a,b,c 라는 숫자를 number와 비교

                # 자릿수를 나눠서, strike & ball을 측정하는 부분
                
                ball_cnt = 0    
                strike_cnt = 0

                # strike 계산기 
                if a == int(check[0]):
                    strike_cnt += 1
                if b == int(check[1]):
                    strike_cnt += 1
                if c == int(check[2]):
                    strike_cnt += 1

                # ball 계산기
                if(a == int(check[1]) or a == int(check[2])):
                    ball_cnt += 1
                if(b == int(check[0]) or b == int(check[2])):
                    ball_cnt += 1
                if(c == int(check[0]) or c == int(check[1])):
                    ball_cnt += 1



                if ball != ball_cnt:
                    break
                if strike != strike_cnt:
                    break
                
                cnt += 1

            if cnt == n:
                ans += 1

print(ans)
#수강신청
#교내 기출문제 2016
#데이터 양이 많아서 일반적인 리스트로 풀면 시간초과 걸릴거같았다.
#고민하다 학번과 입력받는 순서를 딕셔너리로 처리하면 될것 같았다.

import sys

K, L = map(int, sys.stdin.readline().split())

check = {}

for i in range(L):
    userID = sys.stdin.readline().strip()
    check[userID] = i

cnt = 0

for x in sorted(check.items(), key=lambda x: x[1]):
    cnt += 1
    if cnt > K:
        break
    print(x[0])


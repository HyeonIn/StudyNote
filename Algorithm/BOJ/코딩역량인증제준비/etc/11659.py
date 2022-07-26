# 구간 합 구하기 4
# 일반 리스트 합으로 구하면 시간초과 뜸, 구간 합 구해놓고 저장해서
# 저장된 결과로 차이 구하면 끝

import sys

input = sys.stdin.readline

n, m = map(int, input().split())

arr = list(map(int, input().split()))

sumList = [0]

temp = 0

for i in arr:
    temp += i
    sumList.append(temp)

for i in range(m):
    a, b = map(int, input().split())
    print(sumList[b] - sumList[a-1])

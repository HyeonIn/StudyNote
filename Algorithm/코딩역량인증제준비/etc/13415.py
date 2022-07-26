#정렬 게임
#교내 기출문제 2016
#정렬 - 아직 못품

import sys

n = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().split()))

k = int(sys.stdin.readline())

for _ in range(k):
    a , b = map(int, sys.stdin.readline().split())
    arr1 = sorted(arr[0:a]) + arr[a:]
    arr = sorted(arr1[0:b], reverse=True) + arr1[b:]

for x in arr:
    print(x, end=" ")


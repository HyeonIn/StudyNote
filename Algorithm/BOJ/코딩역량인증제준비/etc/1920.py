# 수 찾기

import sys

n = int(sys.stdin.readline())

Nlist = list(map(int, sys.stdin.readline().split()))
Nlist.sort()

m = int(sys.stdin.readline())

Mlist = list(map(int, sys.stdin.readline().split()))

def binary(m):
    left = 0
    right = n -1

    while left <= right:
        mid = (left+right)//2
        if Nlist[mid] == m:
            return True

        if m < Nlist[mid]:
            right = mid-1
        else:
            left = mid + 1

for i in Mlist:
    if binary(i):
        print(1)
    else:
        print(0)
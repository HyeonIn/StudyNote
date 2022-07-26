#섬의 개수
#간단한 8방향 탐색 문제

import sys
from collections import deque
import pprint

input = sys.stdin.readline

dx = [-1,-1,-1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, 1,-1, 1, 0,-1]

def bfs(i, j, w, h, count):
    q = deque([(i,j)])

    while q:
        x, y = q.popleft()
        for it in range(8):
            nx = x+dx[it]
            ny = y+dy[it]
            if 0<=nx<h and 0<=ny<w and island[nx][ny] == 1:
                    island[nx][ny] = 0
                    q.append((nx,ny))


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    island = [list(map(int, input().split())) for _ in range(h)]
    check = [[0] * w for _ in range(h)]

    count = 0

    for i in range(h):
        for j in range(w):
            if island[i][j] == 1 and check[i][j] == 0:
                check[i][j] = count
                bfs(i,j, w, h, count)
                count += 1

    print(count)







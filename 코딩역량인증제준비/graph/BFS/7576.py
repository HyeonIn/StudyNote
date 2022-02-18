#토마토
#4방향 탐색, BFS 이용 최단거리 구하는 문제

import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

M, N = map(int, sys.stdin.readline().split())

farm = []

q = deque([])

for i in range(N):
    farm.append(list(map(int, sys.stdin.readline().split())))

    for j in range(M):
        if farm[i][j] == 1:
            q.append((i,j))

def bfs():
    while q:
        x, y = q.popleft()

        for i in range(4):

            nx = x+dx[i]
            ny = y+dy[i]

            if 0 <= nx < N  and  0 <= ny < M and farm[nx][ny] == 0 :
                q.append((nx,ny))
                farm[nx][ny] = farm[x][y] + 1

bfs()

answer = 0
for i in farm:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    answer = max(answer, max(i))

print(answer-1)
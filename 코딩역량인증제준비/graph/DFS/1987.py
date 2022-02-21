#알파벳
#dfs

import sys
from collections import deque

r, c = map(int, sys.stdin.readline().split())

board = [sys.stdin.readline().strip() for i in range(r)]

alphas = set(board[0][0])

answer = 1

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x, y):

    global answer

    q = set([(x,y,board[x][y])])
    while q:
        x,y,alphas = q.pop()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<r and 0<=ny<c and not board[nx][ny] in alphas:
                q.add((nx,ny,alphas + board[nx][ny]))
                answer = max(answer, len(alphas)+1)


bfs(0,0)
print(answer)
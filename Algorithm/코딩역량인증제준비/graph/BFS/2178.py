#미로 탐색
#bfs, 그래프
#1트 시간초과..
#미로가 주어지면 최소경로 찾는 문제..
#처음엔 bfs로 풀려고 check 배열을 만들었는데 사실 그냥 탐색하면서 입력 배열을 바꾸는 식으로 해도 됨
# 시간초과가 났는데 그 이유가 stdin 을 안써서 그런건지 아니면 쓸데없는 조건문이 많았던건지 모르겠음
# 아마 조건문 인거 같음

import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = [list(input()) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

q = [[0,0]]

arr[0][0] = 1

while q:

    x, y = q[0]

    del q[0]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= 0 and ny >= 0 and nx < n and ny < m:
            if arr[nx][ny] == "1":
                q.append([nx,ny])
                arr[nx][ny] = arr[x][y] + 1

print(arr[n-1][m-1])


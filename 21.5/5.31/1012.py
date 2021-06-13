def bfs(x, y):
  dx = [1, 0, -1, 0]
  dy = [0, 1, 0, -1]
  queue = [[x, y]]
  
  while queue:
    a = queue[0][0]
    b = queue[0][1]
    del queue[0]
    
    for i in range(4):
      q = a + dx[i]
      w = b + dy[i]
      if 0 <= q < n and 0 <= w < m and mat[q][w] == 1:
        mat[q][w] = 0
        queue.append([q, w])



t = int(input())

for i in range(t):
  m, n, k = map(int, input().split())
  mat = [[0]*m for j in range(n)]
  for _ in range(k):
    x, y = map(int, input().split())
    mat[y][x] = 1
  count = 0
  for q in range(n):
    for w in range(m):
      if mat[q][w] == 1:
        bfs(q, w)
        mat[q][w] = 0
        count += 1

  print(count)

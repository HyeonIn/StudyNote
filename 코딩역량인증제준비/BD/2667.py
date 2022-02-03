#단지번호 붙이기
#4방향 탐색, BFS

n = int(input())

Apart = [input() for _ in range(n)] #입력 받기, 어차피 문자열도 인덱스접근가능하니까
                                    #굳이 2차원 리스트로 안만들어도 됨
check = [[False]*n for i in range(n)] #[False] * n을 했는데 결과가 예상과 달라서 신기

#탐색 방향 설정, 4방향임
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(i, j, map):

    q = [] #4방향 탐색을 해야되는 지점을 넣는 큐
    q.append((i, j)) #인자로 넘어온 i,j 를 우선 넣고
    count = 1 #이 문제에서는 붙어있는 아파트의 갯수를 세라고 해서 카운트 변수 추가
              #i,j 지점은 탐색되었으니 1부터 시작

    while q: #큐가 비어있지 않다면

        x,y = q.pop(0) #x,y를 큐에서 하나 뽑아오고

        for k in range(4): # 4방향 탐색 시작
            nx, ny = x + dx[k], y+dy[k]

            if nx<0 or ny<0 or nx>=n or ny>=n: #인덱스를 넘어가는지 체크해주고
                continue # 숫자로 먼저 계산을 하면 에러가 발생하지 않는다!

            if map[nx][ny] == "1":
                if not check[nx][ny]:
                    check[nx][ny] = True
                    q.append((nx, ny))
                    count += 1
    return count

answer = []

for i in range(n):
    for j in range(n):
        if not check[i][j] and Apart[i][j] == "1":
            check[i][j] = True
            answer.append(bfs(i, j, Apart))

answer.sort()
print(len(answer))
for i in answer:
    print(i)
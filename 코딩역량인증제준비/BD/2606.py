#바이러스
#그래프, bfs
#1번 컴퓨터가 바이러스에 걸리면 몇대가 걸리는지 출력
# 리스트로 그래프 연결관계 정리한 다음에 다 탐색하면서 해결

n = int(input())

m = int(input())

computers = [[] for _ in range(n)]
check = [False for _ in range(n)]

for _ in range(m):
    a, b = map(int, input().split())
    computers[a-1].append(b-1)
    computers[b-1].append(a-1)


q = [0]
count = 0
check[0] = True
while q:

    x = q[0]
    del q[0]

    for i in computers[x]:
        if not check[i]:
            q.append(i)
            count += 1
            check[i] = True

print(count)


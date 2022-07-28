# 부녀회장이 될테야 by acmicpc
# 20.05.09(SUN)

t = int(input())

for _ in range(t):  
    floor = int(input())  # 층
    num = int(input())  # 호
    f0 = [x for x in range(1, num+1)]  # 0층 리스트
    for k in range(floor):  # 층 수 만큼 반복
        for i in range(1, num):  # 1 ~ n-1까지 (인덱스로 사용)
            f0[i] += f0[i-1]  # 층별 각 호실의 사람 수를 변경
    print(f0[-1])  # 가장 마지막 수 출력

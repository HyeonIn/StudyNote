#오셀로 재배치
#교내 기출문제 2016
# 구현문제 같은데 쉬워보인다
# 그리디, 문자열

import sys

T = int(sys.stdin.readline())

for _ in range(T):
    n = int(sys.stdin.readline())

    before = sys.stdin.readline().strip()
    after = sys.stdin.readline().strip()

    #결국 말의 개수로 풀 수 있는 문제다. B와 W의 개수가 같은 만큼은 서로 바꿀것이고
    #다른 만큼은 해당 말을 뒤집으면 되는 것, 따라서 두 말의 개수중에서 큰 말의 개수가
    #정답이 된다.

    #바꿔야 하는 말의 개수를 딕셔너리 형태로 저장
    diff = {"B" : 0, "W" : 0}
    for i in range(n):
        #목표 상태와 현재 상태를 비교하여 다를경우
        if after[i] != before[i]:
            #바꿔야 하는 말의 개수를 늘려준다.
            diff[before[i]] += 1

    #W, B 중에 더 많이 바꿔야 하는 쪽을 출력한다.
    print(max(diff["B"], diff["W"]))
#프로그래머스

import math
def solution(brown, yellow):
    answer = []
    a = []
    totalSquare = brown + yellow
    for i in range(3, round(math.sqrt(totalSquare))+1):
        if totalSquare%i == 0:
            a.append([totalSquare//i, i])
    for j in range(len(a)):
        if (a[j][0]*2) + ((a[j][1]-2)*2) == brown:
            answer.append(a[j][0])
            answer.append(a[j][1])
    
    return answer
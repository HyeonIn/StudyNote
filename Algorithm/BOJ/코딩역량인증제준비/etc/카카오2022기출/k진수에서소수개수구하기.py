#레벨 2, 풀었음
import math


def is_prime(n):
    if n == 1:
        return False

    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False  # 소수가 아님
    return True  # 소수임


def solution(n, k):
    answer = 0

    ntok = ""
    while n // k != 0:
        ntok += str(n % k)
        n //= k
    ntok += str(n)
    ntok = ntok[::-1]

    temp_number = ""

    for i in range(len(ntok)):
        if ntok[i] != '0':
            temp_number += ntok[i]
        if ntok[i] == '0' and temp_number != "":
            if is_prime(int(temp_number)):
                answer += 1
            temp_number = ""

    if temp_number != "":
        if is_prime(int(temp_number)):
            answer += 1

    return answer
# 팩토리얼 by acmicpc
# 20.05.11(TUE)

# 재귀함수 연습

n = int(input())


def fact(n):
  if n <= 1:
    return 1
  else:
    return n * fact(n-1)

print(fact(n))
# 별찍기 - 10 by acmicpc
# 20.05.11(TUE)

# 재귀함수 연습

def star(n):
  if n == 3:
    for i in range(n):
      for j in range(n):
        if i // 3 == 1 and j //3 == 1
        print("*")

    print("*" * 3)
  else:
    return n * fact(n-1)


n = int(input())

print(fact(n))
# 달팽이는 올라가고 싶다 by acmicpc
# 20.05.07(FRI)

a,b,v = map(int, input().split())

c = a-b

print((v-b-1)//c+1)
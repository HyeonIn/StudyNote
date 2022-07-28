a = int(input())
b = int(input())

c = a*(b%10)
b//=10
d = a*(b%10)
b//=10
e = a*b


print(c)
print(d)
print(e)
print(c+d*10+e*100)
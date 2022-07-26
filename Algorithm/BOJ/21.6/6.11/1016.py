import math
min, max = map(int, input().split())
validate = [1 for i in range(max-min+1)]
cnt=0
i=2
while i**2 <= max:
    mul = min // i**2
    while mul * (i**2) <= max:
        if mul * (i**2) - min >= 0 and mul * (i**2) - min <= max-min:
            validate[mul * (i**2) - min] = 0
        mul +=1
    i +=1

print(sum(validate))
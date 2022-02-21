#일곱난쟁이
#7명 아무나 뽑아서 조합때린다음 합구해서 100이면 바로 출력

import sys
from itertools import combinations

heights = [int(sys.stdin.readline()) for _ in range(9)]

sn = []

for now in list(combinations(heights, 7)):
    if sum(now) == 100:
        sn = sorted(now)
        break

for i in range(7):
    print(sn[i])
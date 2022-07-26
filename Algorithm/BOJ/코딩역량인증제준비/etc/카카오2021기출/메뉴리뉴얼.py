# 주문 조합을 딕셔너리에 저장하고 해당 조합이 얼마나 나오는지 카운팅
# 변수가 조금 있었는데 주문이 순서가 꼬여있으면 조합 결과가 좀 달라져서
# 이거 찾느라 조금 시간 지체됨 그래서 총 30분정도 걸린듯,, 풀어서 조금 뿌듯;

from itertools import combinations


def solution(orders, course):
    course_dict = {}
    for order in orders:
        for i in course:
            for o in combinations(sorted(list(order)), i):
                if o in course_dict:
                    course_dict[o] += 1
                else:
                    course_dict[o] = 1
    max_list = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    for c in course:
        max_order = 0
        for i in course_dict.keys():
            if len(i) == c and course_dict[i] != 1:
                if course_dict[i] > max_order:
                    max_order = course_dict[i]
        max_list[c] = max_order

    answer = []

    for i in course_dict.keys():
        if course_dict[i] == max_list[len(i)]:
            answer.append("".join(i))

    answer.sort()
    return answer
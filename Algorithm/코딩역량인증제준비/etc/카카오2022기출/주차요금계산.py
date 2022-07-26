#레벨 2, 풀었음

import math


def cal_time(start, end):
    sh, sm = map(int, start.split(":"))
    eh, em = map(int, end.split(":"))

    return (eh * 60 + em) - (sh * 60 + sm)


def solution(fees, records):
    total_time = {}

    q = {}

    for record in records:
        time, car_number, IO = record.split()

        if IO == "IN":
            if car_number not in total_time:
                total_time[car_number] = 0
            q[car_number] = time
        if IO == "OUT":
            total_time[car_number] += cal_time(q[car_number], time)
            del q[car_number]

    for i in q:
        total_time[i] += cal_time(q[i], "23:59")

    answer = []

    ST = sorted(total_time.items())
    for car in ST:
        if car[1] > fees[0]:
            answer.append(fees[1] + (math.ceil((car[1] - fees[0]) / fees[2])) * fees[3])
        else:
            answer.append(fees[1])
    return answer
#레벨 1, 풀었음


def solution(id_list, report, k):
    ban_count = {}
    ban_user = {}
    ban_list_set = set()
    answer = []

    for ID in id_list:
        ban_count[ID] = 0
        ban_user[ID] = []

    for ban_report in report:
        user, ban = ban_report.split()
        if ban not in ban_user[user]:
            ban_user[user].append(ban)
            ban_count[ban] += 1
    for user in id_list:
        mail_count = 0
        for b_user in ban_user[user]:
            if ban_count[b_user] >= k:
                mail_count += 1
        answer.append(mail_count)

    return answer
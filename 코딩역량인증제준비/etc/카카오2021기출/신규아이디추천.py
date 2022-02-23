# 레벨 1 문제치고 조금 귀찮았다.
# 난이도는 쉬운데 하드코딩이고 간결하게 풀고싶어도 시간이 아깝다...
# 실전에가면 이것도 간결하게 풀어야 하나..
# 라고 생각했는데 내가 파이썬 문법을 많이 놓치고 있나 보다 다른 사람 풀이보니까 많이 짧네;;
# 짧은 거 뿐만 아니라 리스트로 굳이 안바꿔도 충분히 가능하네요 파이썬은..ㅠ

def solution(new_id):
    answer = []
    ban = ['~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', '{', ']', '}', ':', '?', "'", ',', '<',
           '>', '/']

    is_dot = False

    new_id2 = []

    for i in range(len(new_id)):
        if new_id[i] == ".":
            if len(new_id2) == 0:
                continue
            else:
                if is_dot:
                    continue
                else:
                    new_id2.append(new_id[i])
                    is_dot = True
        else:
            is_dot = False
            if 65 <= ord(new_id[i]) <= 90:
                new_id2.append(chr(ord(new_id[i]) + 32))
            elif new_id[i] in ban:
                continue
            else:
                new_id2.append(new_id[i])
    is_dot = False
    for i in new_id2:
        if i == ".":
            if len(answer) == 0:
                continue
            else:
                if is_dot:
                    continue
                else:
                    answer.append(i)
                    is_dot = True
        else:
            is_dot = False
            answer.append(i)
    if len(answer) != 0:
        if answer[-1] == ".":
            del answer[-1]

    while len(answer) < 3:
        if len(answer) == 0:
            answer = ['a', 'a', 'a']
        else:
            answer.append(answer[-1])

    if len(answer) > 15:
        answer = answer[0:15]
        if answer[-1] == ".":
            del answer[-1]

    answer = "".join(answer)

    return answer

'''
def solution(new_id):
    # 1단계 - 소문자 변경
    new_id = new_id.lower()
    # 2단계 - 특수문자 삭제
    answer = ''

    #여기가 ㄹㅇ 킬포네; isalnum은 생각도 못했다
    for word in new_id:
        if word.isalnum() or word in '-_.':
            answer += word

    #3단계 - .. 제거 replace 활용 있었네
    while '..' in answer:
        answer = answer.replace('..', '.')

    #4단계 - 문자열 앞뒤 . 제거
    answer = answer[1:] if answer[0] == '.' and len(answer) > 1 else answer
    answer = answer[:-1] if answer[-1] == '.' else answer

    # 5단계
    answer = 'a' if answer == '' else answer
    
    # 6단계
    if len(answer) >= 16:
        answer = answer[:15]
        if answer[-1] == '.':
            answer = answer[:-1]
    # 7단계
    if len(answer) <= 3:
        answer = answer + answer[-1] * (3 - len(answer))
    return answer
'''
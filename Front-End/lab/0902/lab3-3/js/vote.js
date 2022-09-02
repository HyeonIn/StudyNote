document.getElementById('add_ans').onclick = addAns;

function addAns() {
    let newAns = '<div id="list1"><input type="text" class="voteList"></div>';
    document.querySelector('#voteList').innerHTML += newAns;
}

document.getElementById('btn_make_vote').onclick = makeVote;

function makeVote() {
    let startDate = document.querySelector('#start_date').value;
    let endDate = document.querySelector('#end_date').value;
    if (!startDate || !endDate) {
        alert('기간을 입력해주세요');
        return;
    }

    let question = document.querySelector('#voteTitle').value;
    if (!question) {
        alert('질문을 입력해주세요!');
    }

    let answersInputs = document.querySelectorAll('.voteList');
    let saveAnswers = [];
    for (let index = 0; index < answersInputs.length; index++) {
        if (answersInputs[index].value) {
            saveAnswers.push(answersInputs[index].value);
        }
    }

    let vote = {
        'start_date': startDate,
        'end_date': endDate,
        'question': question,
        'answers': saveAnswers
    };

    localStorage.setItem('vote', JSON.stringify(vote));
    opener.document.location.reload();
    self.close();
}
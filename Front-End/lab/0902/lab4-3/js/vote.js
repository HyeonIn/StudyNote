let btn_add = document.querySelector('#add_ans');

btn_add.addEventListener('click', function () {
    let voteList = document.querySelector('#voteList');
    voteList.innerHTML += '<div id="list1"><input type="text" class="voteList"></div>';
});

let btn_make_poll = document.querySelector('#btn_make_vote');

btn_make_poll.addEventListener('click', function () {
    let startDate = document.querySelector('#start_date').value;
    let endDate = document.querySelector('#end_date').value;
    if (!startDate || !endDate) {
        alert('날짜를 확인해주세요');
        return;
    }
    let question = document.querySelector('#voteTitle').value;
    if (!question) {
        alert('질문 내용을 입력해주세요!!');
        return;
    }
    let answers = [];
    let voteList = document.querySelectorAll('.voteList');
    for (let voteContent of voteList) {
        answers.push(voteContent.value);
    }
    let vote = {
        startdate: startDate,
        enddate: endDate,
        votetitle: question,
        votelist: answers
    };

    localStorage.setItem('vote', JSON.stringify(vote));
    opener.document.location.reload();
    self.close();
});
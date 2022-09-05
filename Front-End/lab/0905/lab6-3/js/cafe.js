let login_btn = document.querySelector('#login');

login_btn.addEventListener('click', function () {
    let id = prompt('ID를 입력해주세요', 'ssafy');
    if (!id) {
        alert('아이디를 입력하세요!!!');
        return;
    }
    let password = prompt('비밀번호를 입력해주세요', '1234');
    if (!password) {
        alert('비밀번호를 입력하세요!!!');
        return;
    }
    if (id == 'ssafy' || password == '1234') {
        alert('로그인 성공');
        document.querySelector('.profile_img').setAttribute('src', 'img/profile.png')
        document.querySelector('.header_nav_menu_before').setAttribute('style', 'display : none;');
        document.querySelector('.header_nav_menu_after').setAttribute('style', 'display : block;');
    }
});

let logout_btn = document.querySelector('#logout');

logout_btn.addEventListener('click', function () {
    document.querySelector('.profile_img').setAttribute('src', 'img/noimg.png')
    document.querySelector('.header_nav_menu_before').setAttribute('style', 'display : block;');
    document.querySelector('.header_nav_menu_after').setAttribute('style', 'display : none;');
});


let vote = localStorage.getItem('vote');
if (!vote) {
    document.querySelector('.vote').innerHTML = '진행중인 투표가 없습니다';
} else {
    vote = JSON.parse(vote);

    document.querySelector('.vote_question').innerHTML = vote.votetitle;
    for (let answer of vote.votelist) {
        document.querySelector('.vote_answer')
            .innerHTML += '<div><input type="radio" style="margin-left : 5px;"> '+ answer + '</div>';
    }
    document.querySelector('.vote_button').setAttribute('style', 'display: block');
    document.querySelector('.vote_date')
        .innerHTML = '투표 기간 : ' + vote.startdate.substr(2) + '~' + vote.enddate.substr(2);
}

let btn_add = document.querySelector('#add_ans');

btn_add.addEventListener('click', function () {
    let voteList = document.querySelector('#voteList');
    voteList.innerHTML += '<input type="text" class="voteList form-control" />';
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
    document.location.reload();
});
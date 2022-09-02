document.getElementById('login').onclick = login;
function login () {
    let id = prompt("아이디 입력", "아이디 입력");
    if (!id) {
        alert('Input id !!');
        return;
    }
    let password = prompt("비밀번호 입력", "비밀번호 입력");
    if (!password) {
        alert('Input Password !!');
        return;
    }
    if (id == "ssafy" && password == "1234") {
        alert("로그인 성공!!!");           
        document.querySelector('.header_nav_menu_before').setAttribute('style', 'display : none');
        document.querySelector('.header_nav_menu_after').setAttribute('style', 'display : block');
        document.querySelector('.profile_img').setAttribute('src', "img/profile.png");
    }
    else {
        alert("로그인 실패");
    }
}
document.getElementById('logout').onclick = logout;
function logout () {
    document.querySelector('.header_nav_menu_before').setAttribute('style', 'display : block');
    document.querySelector('.header_nav_menu_after').setAttribute('style', 'display : none');
    document.querySelector('.profile_img').setAttribute('src', "img/noimg.png");
}

var regionView = function (region) {
    if (document.getElementById(region).style.display == 'none') {
        document.getElementById(region).style.display = 'block';
    }
    else {
        document.getElementById(region).style.display = 'none';
    };

}
document.getElementById('total').onclick = totalView;
function totalView () {
    var regions = document.getElementsByClassName('store_item_sub');
    var dis = 'none';
    
    if (document.querySelector('#total').innerHTML == '전국매장펼치기') {
        document.querySelector('#total').innerHTML = '전국매장접기';
        for (let index = 0; index < 4; index++) {
            regions[index].style.display = 'block';
        }
    } else {
        document.querySelector('#total').innerHTML = '전국매장펼치기'
        for (let index = 0; index < 4; index++) {
            regions[index].style.display = 'none';
        }
    }
}
let vote = localStorage.getItem('vote');
if (vote) {
    vote = JSON.parse(vote);
    
    document.querySelector('.vote_question').innerHTML = vote.question;
    
    for (let index = 0; index < vote.answers.length; index++) {
        let newVote = '';
        newVote += '<div><input type="radio">'
        newVote += vote.answers[index];
        newVote += '</div>';
        document.querySelector('.vote_answer').innerHTML += newVote;
    }
    document.querySelector('.vote_button').setAttribute('style', 'display : block;');
    document.querySelector('.vote_date').innerHTML += '투표기간:' + vote.start_date.substr(2) + '~' + vote.end_date.substr(2);
} else {
    document.querySelector('.vote')
        .innerHTML = '진행중인 투표가 없습니다';
}

document.getElementById('admin').onclick = openWindow;
function openWindow () {
    window.open("./pollmake.html", 'vote', 'width = 400, height =350');
}



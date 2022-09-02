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

let btn_region = document.querySelectorAll('.store_area');

for (let index = 0; index < btn_region.length; index++) {
    let region = btn_region[index];
    region.addEventListener('click', function () {
        let region_list = document.querySelectorAll('.store_item_sub')[index];
        if (region_list.getAttribute('style') == 'display: none') {
            region_list.setAttribute('style', 'display: block');
        } else {
            region_list.setAttribute('style', 'display: none');
        }
    })
    
}
let btn_All = document.querySelector('#total');

btn_All.addEventListener('click', function () {
    let regions = document.querySelectorAll('.store_item_sub');
    if (btn_All.innerHTML == '전국매장펼치기') {
        for (let region of regions) {
            region.setAttribute('style', 'display : block;');
        }
        btn_All.innerHTML = '전국매장접기';
    } else {
        for (let region of regions) {
            region.setAttribute('style', 'display : none;');
        }
        btn_All.innerHTML = '전국매장펼치기';
        
    }
})

let btn_admin = document.querySelector('#admin');

btn_admin.addEventListener('click', function () {
    window.open('./pollmake.html', 'vote', 'width = 400, height = 400');
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
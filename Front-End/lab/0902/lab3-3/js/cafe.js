var login = document.getElementById('login');

var login = function () {
    var id = prompt("아이디 입력", "아이디 입력");
    var password = prompt("비밀번호 입력", "비밀번호 입력");
    if (id == "ssafy" && password == "1234") {
        alert("로그인 성공!!!");   
        let navUnLogin = document.getElementsByClassName('nav_link_unlogin');
        let navLogin = document.getElementsByClassName('nav_link_login');
        
        for (let index = 0; index < 2; index++) {
            navUnLogin[index].style.display = 'none';
        }
        for (let index = 0; index < 3; index++) {
            navLogin[index].style.display = 'block';
        }
        document.getElementById('unlogin_img').style.display = 'none';
        document.getElementById('login_img').style.display = 'block';
    }
    else {
        alert("로그인 실패");
    }
}

var logout = function () {
    let navUnLogin = document.getElementsByClassName('nav_link_unlogin');
    let navLogin = document.getElementsByClassName('nav_link_login');
        
    for (let index = 0; index < 2; index++) {
        navUnLogin[index].style.display = 'block';
    }
    for (let index = 0; index < 3; index++) {
        navLogin[index].style.display = 'none';
    }
    document.getElementById('unlogin_img').style.display = 'block';
    document.getElementById('login_img').style.display = 'none';
}


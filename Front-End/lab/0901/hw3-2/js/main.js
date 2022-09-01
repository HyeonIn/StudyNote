function regist() {
    // 각 form 의 input 에 입력된 값들을 css 선택자를 이용하여 가져오기
    let id = document.getElementById('id').value;
    let password = document.getElementById("password").value;
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let age = document.getElementById("age").value;
  
    // user 생성
    const user = {
      id: id,
      password: password,
      name: name,
      email: email,
      age: age,
    };
  
    // user 정보 출력
    console.log(user);
  }
  
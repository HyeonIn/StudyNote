## 3. Git을 이용하여 소스코드 관리하기(with VSCode)

프로젝트의 효율적인 관리를 위해 Git을 사용하게 될텐데, React는 어떤 방식으로 깃에서 코드를 관리하는지 알아보자

1. **깃 레포지토리 생성**
2. **로컬 저장소에 변경사항 커밋하기**
    1. VSCode에서 소스 제어로 이동
    2. Changes안에 있는 파일들은 수정된 파일이고 현재 로컬 저장소에 반영 되지 않은 상태임
    3. ‘+’ 버튼을 눌러서 Staged 상태로 변경하면 커밋 될 준비가 된 상태로 변경됨
    4. 커밋 메세지를 작성하고 커밋을 하면 로컬 저장소에 변경사항이 저장됨
3. **원격 저장소(Git)에 로컬 저장소 커밋 내역 올리기**
    1. VSCode에서 터미널 실행(윈도우 일때 터미널 종류는 Power Shell, Git Bash 둘 다 가능)
        1. Terminal > New Terminal
    2. 터미널을 통해 원격 저장소에 push 하기
    
        ```bash
        // 원격 저장소가 등록이 안된 경우 아래 코드 먼저 실행
        git remote add origin [git 주소]
        
        git push --set-upstream origin [branch명]
        ```
    

```💡 gitignore 파일을 활용하여 node 모듈들은 원격 저장소에 올라가지 않도록 하기!```

## 2. VSCode를 이용한 소스코드 작성

- 리액트 개발에 있어서 가장 효과적인 IDE 중 하나가 VSCode이다.
- 프로젝트 실행 상태에서 소스코드를 수정하면 새로고침 없이 자동으로 반영된다
    - 소스코드 변경 후 저장만 하면 반영되기 때문에 개발 속도가 빠르다

### VSCode에서 내 프로젝트 폴더 열기

- VSCode 실행 > File > Open Folder > 프로젝트 폴더 선택

### VSCode 사용 시, js 파일 안에서 HTML Snippet이 적용 안될 때

- File > Pereference > setting > 우상단에 소스코드 전환 클릭 > 아래 코드 추가
    
    ```json
    "emmet.includeLanguages": {
            "javascript" : "javascriptreact"
        }
    ```
### axios

##### HTTP 통신 : axios

- Vue에서 권고하는 HTTP 통신 라이브러리는 axios이다
- Promise 기반의 HTTP 통신 라이브러리들에 비해 문서화가 잘 되어있고 API가 다양하다.
- axios.get(URL) << Promise 객체를 리턴 >> then, catch 사용 가능
- https://github.com/axios/axios

> Promise란 서버에 데이터를 요청하여 받아오는 동작과 같은 비동기 로직 처리에 유용한 자바스크립트 라이브러리이다. 자바 스크립트는 단일 스레드 코드를 처리하기 때문에 특정 로직의 처리가 끝날 때까지 기다려 주지 않는다. 따라서 데이터를 요청하고 받아올 때 까지 기다렸다가 화면에 나타내는 로직을 실행해야 할 때 주로 Promise를 활용한다. 그리고 데이터를 받아왔을 때 Promise로 데이터를 화면에 표시하거나 연산을 수행하는 등 특정 로직을 수행한다.

##### axios 설치

- CDN 방식
  - `<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>`
- NPM 방식
  - `npm install axios`

##### axios 대표 API

- `axios.get('URL 주소').then().catch()`
  - 해당 URL 주소에 대해 HTTP GET 요청을 보냄. 서버에서 보낸 데이터를 정상적으로 받아오면 then() 안에 정의된 로직이 실행되고, 데이터를 받아올 때 오류가 발생하면 catch()에 정의한 로직이 실행
- `axios.post('URL 주소').then().catch()`
  - 해당 URL 주소에 대해 HTTP POST 요청을 보냄. then()과 catch()는 get 방식과 동일
- `axios({옵션 속성})`
  - HTTP 요청에 대한 자세한 속성들을 직접 정의하여 보낼 수 있다. 데이터 요청을 보낼 URL, HTTP 요청방식, 보내는 데이터 유형 등..
- 그외 API
  - https://github.com/axios/axios#axios-api



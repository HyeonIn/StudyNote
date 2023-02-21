## 7. REST API 실습

### REST?

- REST는 HTTP 프로토콜을 통해 API를 설계하기 위한 아키텍처 스타일이며 주요 이점은 뛰어난 유연성이다.
- 개발자는 서버에서 직접 웹 애플리케이션이나 사이트의 사용자에게 데이터를 제공해야 하는 모든 곳에서 REST API를 사용한다.

**REST API의 주요 구성요소**

- 고객 — 통신을 시작하는 사용자 측(자신의 장치에서)에서 시작된 클라이언트 또는 프로그램.
- 섬기는 사람 — API를 기능 및 데이터에 대한 액세스로 사용하는 서버.
- 자원 — 서버가 클라이언트에 전송하는 모든 콘텐츠(비디오, 텍스트, 사진).

**REST API 작동 방식**

 REST API는 HTTP 요청을 통해 통신하여 데이터 생성, 읽기, 업데이트 및 삭제 기능을 완료합니다. CRUD 작업이라고도 합니다. REST는 요청된 리소스에 대한 정보를 제공하고 리소스로 수행할 작업을 설명하는 네 가지 방법을 사용합니다.

- **POST** — 리소스 생성
- **GET** — 리소스 가져오기
- **PUT** — 리소스 업데이트
- **DELETE** — 리소스를 삭제합니다

### React에서 REST API 사용하기(with axios)

우선 API 를 호출하기 위해서 [a](https://github.com/axios/axios)xios 라이브러를 설치한다.

```bash
cd api-integrate
yarn add axios
```

**axios 사용법**

```
import axios from 'axios';

axios.get('/users/1');

```

`get` 이 위치한 자리에는 메서드 이름을 소문자로 넣는다. 예를 들어서 새로운 데이터를 등록하고 싶다면 `axios.post()` 를 사용하면 된다. 그리고, 파라미터에는 API 의 주소를 넣는다. `axios.post()` 로 데이터를 등록 할 때에는 두번째 파라미터에 등록하고자 하는 정보를 넣을 수 있습니다.

```bash
axios.post('/users', {
  username: 'blabla',
  name: 'blabla'
});
```

**useState 와 useEffect 로 데이터 로딩하기**

`useState` 를 사용하여 요청 상태를 관리하고, `useEffect` 를 사용하여 컴포넌트가 렌더링되는 시점에 요청을 시작하는 작업을 해보자.

요청에 대한 상태를 관리 할 때에는 다음과 같이 총 3가지 상태를 관리해주어야 한다.

1. 요청의 결과
2. 로딩 상태
3. 에러

### 예제 코드

```
//Users.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Users() {
  const [users, setUsers] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        // 요청이 시작 할 때에는 error 와 users 를 초기화하고
        setError(null);
        setUsers(null);
        // loading 상태를 true 로 바꿉니다.
        setLoading(true);
        const response = await axios.get(
          'https://jsonplaceholder.typicode.com/users'
        );
        setUsers(response.data); // 데이터는 response.data 안에 들어있습니다.
      } catch (e) {
        setError(e);
      }
      setLoading(false);
    };

    fetchUsers();
  }, []);

  if (loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!users) return null;
  return (
    <ul>
      {users.map(user => (
        <li key={user.id}>
          {user.username} ({user.name})
        </li>
      ))}
    </ul>
  );
}

export default Users;

```

- `useEffect` 에 첫번째 파라미터로 등록하는 함수에는 `async` 를 사용 할 수 없기 때문에 함수 내부에서 `async` 를 사용하는 새로운 함수를 선언해주어야 한다.
- 로딩 상태가 활성화 됐을 땐 `로딩중..` 이라는 문구를 보여줬습니다.
- 그리고, `users` 값이 아직 없을 때에는 `null` 을 보여주도록 처리했습니다.
- 맨 마지막에서는 `users` 배열을 렌더링하는 작업을 해주었다.
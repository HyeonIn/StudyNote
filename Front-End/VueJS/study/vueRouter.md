### vue-router

- 라우팅 : 웹 페이지 간의 이동방법
- Vue.js의 공식 라우터
- 라우터는 컴포넌트와 매핑
- Vue를 이용한 SPA를 제작할 때 유용
- URL에 따라 컴포넌트를 연결하고 설정된 컴포넌트를 보여준다

##### vue-router 설치

- NPM 방식
  - npm install vue-router

##### vue-router 연결

- 'routes' 옵션과 함께 router instance 생성

```javascript
const Main = {
  template: "<div>메인 페이지</div>",
};
const Board = {
  template: "<div>자유 게시판</div>",
};
// 라우터 객체 생성
const router = new VueRouter({
  routes: [
    {
      path: "/",
      component: Main,
    },
    {
      path: "/board",
      component: Board,
    },
  ],
});
```

##### vue-router 이동 및 렌더링

- 네비게이션을 위해 router-link 컴포넌트를 사용
- 속성은 'to' prop을 사용
- 기본적으로 `<router-link>`는 `<a>` 태그로 렌더링

```html
<router-link to="/">Home</router-link>
<router-link to="/board">게시판</router-link>

<!-- 현재 라우트에 맞는 컴포넌트가 렌더링 -->
<router-view></router-view>
```

##### $router, $route

- 라우터 설정

```javascript
const router = new Vue Router({
  routes: [
    ...,
    {
      path: '/board/:no',
      component: BoardView,
    },
    ...
  ],
});
```

- 라우터 링크

`<router-link to="/board/30">30번 게시글</router-link>`

- 전체 라우터 정보

`this.$router`

- 현재 호출된 해당 라우터 정보

```js
this.$route;
this.$route.params.no;
this.$route.path;
```

##### 이름을 가지는 라우트

- 라우트는 연결하거나 탐색을 수행할 때 이름이 있는 라우트를 사용
- Router Instance를 생성하는 동안 routes 옵션에 지정

```js
const router = new VueRouter({
  routes: [
    {
      path: "/",
      name: "main",
      component: Main,
    },
  ],
});
```

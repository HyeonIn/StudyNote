## 4. 컴포넌트 만들기

컴포넌트의 개념을 이해하고 고객 컴포넌트를 만들어서 실습을 진행한다.

### Component

리액트 라이브러리 자체는 HTML 웹 문서를 효과적으로 보여주기 위한 라이브러리이다.

- 컴포넌트는 웹 문서에서 어떠한 내용을 보여주기 위한 기본적인 단위
- 계층적으로 구성될 수 있음
- 실제로 웹 문서에서 그려지게 될 최소 단위

<aside>
💡 src 폴더 안에 components 폴더를 생성해서 컴포넌트들을 모아 놓는다

</aside>

### import / export

- import
    - 특정한 라이브러리나 컴포넌트를 불러 올 때 사용
- export
    - 다른 컴포넌트에서 사용할 수 있도록 해준다

### render()

- 컴포넌트가 실제로 담고있는 내용을 그리기 위한 함수
- return() 안에 출력될 내용(HTML)을 정의한다

### 컴포넌트 구현 방법

```jsx
//Customer.js

import React from 'react' //react 라이브러리 사용

//컴포넌트는 계층적인 구조를 가질 수 있음
//react 라이브러리의 Component를 상속받아서 Customer 컴포넌트를 만듦
class Customer extends React.Component{ 
	//클래스 정의
}

export default Customer; //Customer 컴포넌트를 사용할 때 Customer란 태그로 사용하게 함
```

```jsx
//App.js
import Customer from '[Customer 소스코드 경로]'

..
class App extends Component{
	<Customer/> //Customer 컴포넌트를 Export한 이름으로 태그 작성
}
..
```

### Props

- 속성이라는 의미이며, React에서는 상위 컴포넌트에서 보내는 내용을 뜻함

```jsx
//App.js
import Customer from '[Customer 소스코드 경로]'

const customer = {
	'name'='최현인',
	'age'=19,
}
..
class App extends Component{
	<Customer
		name={customer.name}
		age={customer.age}
	/>
}
..
```

```jsx
//Customer.js

import React from 'react' //react 라이브러리 사용

//this를 이용하여 props에 접근한다.
//계층적인 구조이기 때문에 상위 컴포넌트인 App에서 정보를 받아올 수 있는데
//이 때 this를 이용하여 props에 담긴 내용을 접근 가능하다.
class Customer extends React.Component{ 
	render() {
        return(
            <div>
                <h2>{this.props.name}</h2>
                <p>age : {this.props.age}</p>
            </div>
        )
    }
}

export default Customer; //Customer 컴포넌트를 사용할 때 Customer란 태그로 사용하게 함
```
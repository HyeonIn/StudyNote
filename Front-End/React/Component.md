# 컴포넌트

- 리액트를 사용하여 어플리케이션의 인터페이스를 설계할 때 사용자가 볼 수 있는 요소는 여러가지 컴포넌트로 구성되어 있다
- 컴포넌트는 웹 문서에서 어떠한 내용을 보여주기 위한 기본적인 단위
- 계층적으로 구성될 수 있음
- 실제로 웹 문서에서 그려지게 될 최소 단위
- 데이터가 주어졌을 때 UI를 만들어 준다
- 라이프사이클 API를 이용하여 컴포넌트가 화면에서 나타날 때, 사라질 때, 변화가 일어날 때 주어진 작업들을 처리할 수 있다.
- 임의 메서드를 만들어 특별한 기능을 붙여 줄 수 있다.
- 컴포넌트를 선언하는 두 가지 방식
  - 함수형 컴포넌트
  - 클래스형 컴포넌트

## 클래스형 컴포넌트

- 클래스형 컴포넌트는 state 기능 및 라이프사이클 기능을 사용할 수 있으며 임의 메서드를 정의할 수 있다.
- 클래스형 컴포넌트에는 render 함수가 꼭 있어야 하고, 그 안에서 보여 주어야 할 JSX를 반환 해야 한다.

## 함수형 컴포넌트

- 클래스형 컴포넌트 보다 선언하기 편하다.
- 메모리 자원을 클래스형 컴포넌트 보다 덜 사용한다
- 빌드 후 배포하였을 때 함수형 컴포넌트를 사용하는 것이 결과물의 파일 크기가 더 작다
- 성능과 파일 크기면에서 사실상 큰 차이가 생기지는 않기 때문에 위 사항을 너무 중요하게 여기지 않아도 된다
- 함수형 컴포넌트의 가장 큰 단점은 state와 라이프사이클 API를 사용할 수 없다는 것
- 하지만 v16.8 이후 Hooks 라는 개념이 도입되면서 해결됨
- 공식 메뉴얼에서는 함수형 컴포넌트와 Hooks를 사용하는 것을 권장하고 있음

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

## 5. 컴포넌트 구조화하기

컴포넌트의 내용을 적절히 분리하며 관리하기 쉬워지며 생산성을 높일 수 있다. 따라서 출력할 내용이 많아지면 구조화하여 분리할 필요가 있다.

### 구조화 예시

- 구조화 전

```jsx
class Customer extends React.Component {
    render() {
        return(
            <div>
        <img src={this.props.image} alt="profile" />
                <h2>{this.props.name}({this.props.id})</h2>
        <p>{this.props.birthday}</p>
                <p>{this.props.gender}</p>
                <p>{this.props.job}</p>
            </div>
        )
    }
}

```

- 구조화 후

```jsx
class Customer extends React.Component {
    render() {
        return(
            <div>
                <CustomerProfile id={this.props.id} image={this.props.image} name={this.props.name}/>
                <CustomerInfo birthday={this.props.birthday} gender={this.props.gender} job={this.props.job}/> 
            </div>
        )
    }
}

// image와 이름을 다루는 CustomerProfile 컴포넌트
class CustomerProfile extends React.Component{
    render(){
        return (
            <div>
               <img src={this.props.image} alt="profile" />
                <h2>{this.props.name}({this.props.id})</h2>  
            </div>
        )
    }
}
// 생일, 성별, 직업을 다루는 CustomerInfo 컴포넌트
class CustomerInfo extends React.Component {
    render(){
        return(
            <div>
                <p>{this.props.birthday}</p>
                <p>{this.props.gender}</p>
                <p>{this.props.job}</p>
            </div>
        )
    }
}
```

Customer 컴포넌트를 하위 컴포넌트 두 개로 분리하여 관리한다. 이처럼 계층적으로 컴포넌트를 구성할 수 있으므로 React는 강력한 View 기능을 제공한다.

한 명의 사용자가 아닌 사용자가 여러 명이라면?

- 사용자 데이터를 배열로 관리하여 인덱싱한다
- 인덱스에 접근하기 위해 [] 문법을 사용한다.

### map

- 사용자가 여러명일 때 일일히 모든 원소에 접근하는 코드는 비효율적
- 따라서 반복문을 사용
- map은 JS의 반복 문법이다.
- 예시

```jsx
  const customers = [{
  'id' : 1,
  'image' : 'https://placeimg.com/64/64/1',
  'name' : '홍길동',
  'birthday' : '961222',
  'gender' : '남자',
  'job' : '대학생'
},
{
  'id' : 2,
  'image' : 'https://placeimg.com/64/64/2',
  'name' : '김삿갓',
  'birthday' : '951111',
  'gender' : '남자',
  'job' : '프로그래머'
},
{
  'id' : 3,
  'image' : 'https://placeimg.com/64/64/3',
  'name' : '최현인',
  'birthday' : '980622',
  'gender' : '남자',
  'job' : '취준생'
}]
function App() {
  return (
    <div>
      {
        customers.map(customer => { 
          return (
            <Customer
              key={customer.id}
              id={customer.id}
              image={customer.image}
              name={customer.name}
              birthday={customer.birthday}
              gender={customer.gender}
              job={customer.job}
            />
          )
        })
      }

    </div>
  );
}
```

- 파이썬의 문법과 동일함
- key라는 이름의 props를 꼭 사용해야 함

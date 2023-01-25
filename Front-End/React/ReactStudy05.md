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

<aside>
💡 리액트는 JSX 문법을 따른다.

</aside>

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
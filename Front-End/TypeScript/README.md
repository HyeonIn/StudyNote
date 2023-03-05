# TypeScript 공부

## TypeScript

- TypeScript은 JavaScript 위에 레이어로서 자리잡고 있다
- JavaScript의 기능들을 제공하면서 그 위에 자체 레이어를 추가한다
- 이 레이어가 TypeScript 타입 시스템이다
- 한 마디로 자바스크립트에 타입을 선언할 수 있는 언어라고 볼 수 있다

## 타입스크립트를 사용하는 이유

- 우리가 사용하는 브라우저는 타입스크립트를 이해하지 못해서 결국 자바스크립트로 변환된 이후에 로드된다

### 정적 언어, 디버깅이 편하다

- 동적 언어인 자바스크립트는 런타임에 타입이 결정됨
  - 오류가 실행 이후에 발생하여 에러가 발생한 위치를 찾기 어려움
  - 즉, 디버깅이 어려움
- 반면, 타입스크립트는 정적언어라서 컴파일시에 오류를 발견할 수 있음
  - 실행하기전 컴파일 단계에서 오류를 파악하기에 디버깅이 쉬움

## 기본 타입

타입을 선언하지 않아도 타입스크립트는 변수에 저장된 값을 보고 타입을 추론할 수 있다.

- `string` : 문자열
- `number` : 숫자
- 배열
  - `number[]`
  - `Array<number>`
- 튜플
  - `let b:[string, number]`
  - `b = ["hi", 1]`
- void
  - 함수에서 아무것도 반환하지 않을 때의 타입
- never
  - 항상 에러를 반환하거나
  - 영원히 끝나지 않는 함수 일 경우
- enum
  - javaScript에는 없는 타입
  - 자체 타입으로 사용가능
  - 특정 값만 입력하도록 변수를 설정하고 싶거나, 그 값들이 공통점이 있을 때 사용

    ```TypeScript
    enum Os {
        Window = 3;
        Ios = 10;
        Android;
    }
    console.log(Os["Window"]); // 3
    console.log(Os[10]); // Ios
    ```

- null, undeifined
- object
  - 원시 타입이 아닌 타입을 나타낸다

## 인터페이스(Interface)

- 타입스크립트의 핵심 원칙 중 하나는 타입 검사가 값의 Type에 초점을 맞추고 있다는 것이다
- 이를 duck typing 혹은 structural subtyping 이라고 한다
- 인터페이스는 이런 타입들의 이름을 짓는 역할을 하고 코드 안에 계약을 정의하는 것 뿐만 아니라 프로젝트 외부에서 사용하는 코드의 계약을 정의하는 강력한 방법이다
- '?'를 사용해서 선택적인 프로퍼티를 선언할 수 있다
- readonly를 사용하여 읽기전용 프로퍼티를 선언할 수 있다
  - const vs readonly
    - 변수는 const, 프로퍼티는 readonly
- 문자열 리터럴 타입으로 값을 제한 할 수 있다.

```TypeScript
type Score = "A" | "B" | "C" | "D";

interface User {
    name : stirng;
    age : number;
    gender? :string;
    readonly birthYear : number;
    [grade:number] : Score;
}

let user : User {
    name : 'xx',
    age : 30
}

user.age = 10;
```

- 인터페이스는 프로퍼티로 객체를 기술하는 것 외에, 함수 타입도 설명할 수 있다.
- 인터페이스에 호출 서명을 전달한다
- 매개변수 목록과 리턴 타입만 주어진 함수 선언과 비슷하다
- 각 매개 변수들은 이름과 타입이 모두 필요하다

```TypeScript
interface Add {
    (num1 : number, num2:number) : number;
}

const add : Add = function(x, y){
    return x + y;
}

console.log(add(1,3));
console.log(add(1,3,4)); //에러
console.log(add("1","3")); //에러

interface IsAdult {
    (age:number) : boolean;
}

const a:IsAdult = (age) => {
    return age > 19;
}

a(33) // True
```

- 인터페이스를 implements하여 클래스도 정의할 수 있다
- 확장(extends)이 가능하다
  - 여러 개의 인터페이스를 확장할 수 있다

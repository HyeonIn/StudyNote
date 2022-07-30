## Java 기본

### Variable(변수)

- 자료를 저장하기 위한 메모리 공간으로 타입에 따라 크기가 달라짐

#### 데이터의 종류
- 기본형 : 미리 정해진 크기의 Memory Size로 표현, 변수 자체에 값 저장
  - 기본형의 크기
    - 논리형
      - boolean : true/false
    - 정수형
      - byte : 8bit
      - short : 16bit
      - int : 32bit
      - long : 64bit
    - 실수형
      - float : 32bit
      - double : 64bit
    - 문자형
      - char : 16bit

#### 형 변환(Type casting)
- 변수의 타입을 다른 타입으로 변환하는 것
- 기본형은 기본형끼리, 참조형은 참조형끼리 변환 가능
  - boolean은 다른 기본 타입과 호환되지 않음
  - 기본형과 참조형의 형 변환을 위해서 Wrapper 클래스 사용
- 형 변환 반법
  - 형 변환 연산자(괄호) 사용

#### 기본형의 형변환
- 묵시적 형변환
  - 값의 크기, 타입의 크기가 아닌 타입의 표현 범위가 커지는 방향으로 할당할 경우는 묵시적 형변환 발생
  - 자료의 손실 걱정이 없으므로 JVM에서 서비스 해줌
``` java
byte b = 10;
int i = b;
``` 
- 명시적 형변환
  - 값 손실이 발생할 수 있으므로 프로그래머 책임하에 형변환 진행
``` java
int i = 300;
byte b = (byte)i;
```

### 연산자
- 어떤 기능을 수행하는 기호
- 연산자 우선순위가 같을 경우, 연산 진행 방향에 의해 결정

#### 우선순위 및 연산 방향 정리 표

<img src="https://t1.daumcdn.net/cfile/tistory/990DEF445C90628F3D"/> 

<a align="center">출처 : https://jokerkwu.tistory.com/96</a> 


### 조건문(Conditional Statement)

#### If 조건문
- if, else if, else 구조
``` java
int i = 0;
if (i < 2){
    i += 1;
}
else if (i == 2){
    i += 2;
}
else {
    i += 3;
}
```
#### Switch-Case 조건문
- switch, case, dafult 구조
``` java
int i = 1;
switch(i){
    case 1:
        System.out.println("one");
    case 2:
        System.out.println("two");
        break;
    default:
        System.out.println("default");
}
```

### 반복문

#### for 반복문
- 초기값, 조건식, 증감식의 위치가 명확
- 반복의 회수가 명확한 경우 사용
- index의 증감 활용
```java
//  변수 초기화  반복조건  증감식 
for (int i=0;   i < 10;   i++){
    System.out.print(i); 
} //출력 : 0123456789
```

#### while 반복문
- 반복의 회수가 불명확한 경우
- index 보다는 break, continue 활용
```java
int i = 0; // 변수 초기화
while(i < 10){ //반복 조건
    System.out.print(i);
    i ++; //증감식
} //출력 : 0123456789
```
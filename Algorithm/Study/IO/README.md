## I/O

### 입출력 처리

#### 표준 입출력

- System.in, System.out, System.err

#### 표준 입출력의 대상 변경

- System.setOut(), System.setErr(), System.setIn() 


### Scanner

#### java.util.Scanner

입력 스트림등에서 데이터를 읽어 구분자로 토큰화하고 다양한 타입으로 형변환 하여 리턴해주는 클래스
```java
Scanner sc = new Scanner(System.in);
```
- 생성자 오버로딩
  - Scnnaer(File Source)
  - Scanner(InputStream source)
  - Scanner(String source)

#### 특징
- 입력 스트림을 다루는 방법을 몰라도 손쉽게 입력처리 가능
- 데이터 형변환으로 인한 편리함
- 대량의 데이터 처리 시 수행시간이 비효율적임

#### 주요 메소드
- int **nextInt()**, double **nextDouble()**, String **next()**
  - 유효 문자열 후 **White space(\n,\t,\s)** 문자를 만나면 처리
- String **nextLine()**
  - 개행 문자를 만나면 처리, next와 달리 문자열 안에 띄어쓰기를 할 수 있음

### BufferedReader

#### java.io.BufferedReader

Reader 계열만 생성자의 매개변수로 받을 수 있기 때문에, 입력 스트림인 System.in을 매개변수에 집어넣을 수 없다. 따라서 InputStreamReader 클래스를 이용해서 System.in을 입력 스트림으로 가지는 Reader 객체를 만들어 사용한다.

```java
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
```

#### 특징
- 필터 스트림 유형
- 줄 단위로 문자열 처리 기능 제공
- 대량의 데이터 처리 시 수행시간이 효율적임

#### 주요 메소드
- String readLine()
  - 개행 문자를 기준으로 입력을 처리

#### 문자열 분리

##### StringTokenizer
- 문자열을 구분자를 기준으로 분리해서 저장하기 위한 클래스
```java
StringTokenizer st = new StringTokenizer(String String, String Tokenizer)
```
- String nextToken()
  - 구분자로 분리된 문자에 순차적으로 접근
  - 구분자를 직접 전달할 수도 있긴 하지만 대부분의 문제는 일정한 구분자로 입력을 줌

- StirngTokenizer 외에도 String 클래스의 split 메서드를 사용할 수 있다

#### Scanner와 속도 차이
- 1,000,000개의 입력
  - Scanner : 약 2.8초
  - BufferedReader : 약 0.27초
- 10배 정도의 속도 차이
- 입력 케이스가 많을 수록 BufferedReader 사용이 필수적
  
### StringBuilder
- 문자열의 조작을 지원하는 클래스
- 출력이 많을 경우 사용하면 좋음

```java
StringBuilder sb = new StringBuilder();
```

#### 특징
- 자바에서 상수로 취급되는 문자열을 조작 시마다 새로운 문자열이 생성되는 것을 방지

#### 주요 메소드
- void append(String)
  - 빌더에 문자열 추가
- String toString()
  - 빌더안에 생성된 문자열을 반환
- void setLenght(int)
  - 빌더안에 생성된 문자열의 길이를 설정

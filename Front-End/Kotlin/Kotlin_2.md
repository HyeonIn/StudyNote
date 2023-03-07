# 코틀린 기본 문법

## 패키지 정의 및 가져오기

패키지 사양은 소스 파일의 맨 위에 위치한다.  
디렉토리와 패키지를 일치 시킬 필요 없다. 소스 파일은 파일 시스템에 임의로 배치할 수 있다  

## 프로그램 시작점

`main` 함수를 통해 시작한다  

- main 함수에 기변 개수의 String 인수를 허용한다.
  
## 표준 출력

`print` 사용, 개행 시 `println`

## 함수

```kotlin
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
```

```kotlin
    fun sum(a: Int, b: Int) = a + b
```

- 위 두 함수는 같은 결과를 가진다.  
- 리턴값이 없는 함수는 `Unit` 을 선언하지만, 이는 생략가능하다.

## 변수

- val
  - 읽기 전용 변수 선언, 할당은 최초 한번만 가능
- var
  - 재할당이 가능한 변수는 `var` 사용
- 최상위 레벨에 변수를 선언 가능하다.

## 클래스와 객체의 생성

- 클래스
  - `class` 키워드 사용
  - 프로퍼티의 선언은 클래스 선언부나 본문에서 모두 가능하다.
  - 클래스 선언부에 나열된 매개변수가 있는 기본 생성자는 자동으로 사용 가능하다.
  - 클래스 간의 상속은 `:` 사용
    - 클래스는 기본적으로 최종 클래스이므로 클래스를 상속하려면 `:`을 사용하자

## 주석

- 최신 언어들과 마찬가지로 한 줄 및 여러 줄 주석을 지원한다
- 주석의 중첩이 가능하다

## 문자열 템플릿

- `$` 사용

```kotlin
    var a = 1
    val s1 = "a is $a"
```

- 표현식도 넣을 수 있음

```kotlin
    a = 2

    var s2 = "${s1.replace("is", "was")}, but now is $a"
```

## 조건문 표현

- if, else 문
- 삼항 연산자
  - 삼항 연산자 스타일은 파이썬과 비슷함
  - `if (a > b) a else b`

## For 반복문

- for-in 구조

```kotlin
    for (item in items) {
    println(item)
    }
```

- 인덱스 사용법

```kotlin
    val items = listOf("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
```

## While 반복문

- Java While문 형태와 동일

## When 표현식

```kotlin
fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }
```

- 개인적으로 맘에드는 문법
- 확실히 간편하다

## 범위

- 특정 범위 안에 수를 찾을 때

```kotlin
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }
```

- 파이썬 in 문법과 동일하네요
- in 문법과 for문을 사용하면 파이썬 반복문이랑 똑같은 구조네
- 근데 이제 1씩 증가 안하고 2,3 씩 증가할 때는 `step`을 사용한다는 점이 다르네
- 확실히 가독성 면에서 엄청 신경쓴게 보이는 언어

## 컬렉션

- 컬렉션안에서 반복 가능
- in 연산자를 통한 오브젝트 포함 여부 판단 가능
- 람다식을 통한 필터링과 컬렉션 map 기능도 제공

```kotlin
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
```

## null이 가능한 변수와 null 검사

- null을 참조할 수 있는 경우, 타입 뒤에 `?`을 명시할 것

```kotlin
    // int로 변환 될 수 없는 문자열의 경우 null이 리턴될 수 있음
    fun parseInt(str: String): Int? {
        // ...
    }
```

- nullable 값을 반환하는 함수를 사용할 것

```kotlin
    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        // Using `x * y` yields error because they may hold nulls.
        if (x != null && y != null) {
            // x and y are automatically cast to non-nullable after null check
            println(x * y)
        }
        else {
            println("'$arg1' or '$arg2' is not a number")
        }    
    }
```

## 타입 검사 및 오토캐스팅

- `is` 연산자를 이용하여 객체의 타입을 체크할 수 있다.
- 불변 로컬 변수나 프로퍼티 같은 경우 구체적인 타입인 것이 확인 되면 명시적인 캐스팅이 필요하지 않다.

```kotlin
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // `obj` is automatically cast to `String` in this branch
            return obj.length
        }

        // `obj` is still of type `Any` outside of the type-checked branch
        return null
    }
```

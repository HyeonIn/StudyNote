## Spring Framework

### Spring Framework 등장 배경

##### 과거엔 EJB를 사용하여 어플리케이션 작성
  - 하이 레벨 로직을 자동으로 처리해주어서 어플리케이션 작성을 쉽게 할 수 있음
  - 로우 레벨의 트랙잭션이나 상태관리, 멀티 쓰레딩, 리소스 풀링과 같은 복잡한 Low Level의 API를 이해하지 못하더라도 아무 문제 없이 어플리케이션을 개발할 수 있다.

##### EJB.. 현실에서 반영하기 어려움
  - 코드 수정 후 반영하는 과정 자체가 거창해 기능은 좋지만 복잡한 스펙으로 인한 개발의 효율성이 떨어짐
  - 어플리케이션을 테스트하기 위해서는 반드시 EJB서버가 필요함

##### 웹사이트가 점점 커지면서 엔터프라이즈급의 서비스가 필요하게 되었다
  - 세션빈에서 트랜잭션 관리가 용이함
  - 로그인, 분산처리, 보안 등
- EJB 없이도 엔터프라이즈 어플리케이션을 개발하는 방법이 등장한다.
  - AOP나 DI같은 새로운 프로그래밍 방법론으로 가능
  - POJO로 전언적인 프로그래밍 모델이 가능해 짐

##### 점차 POJO + 경량 프레임워크를 사용하기 시작
- POJO (Plain Old Java Object)
  - 특정 프레임워크나 기술에 의존적이지 않은 자바 객체
  - 특정 기술에 종속적이지 않기 때문에 생산성, 이식성 향상
  - Plain : component interface를 상속받지 않는 특징
  - Old : EJB 이전의 java class를 의미
- 경량 프레임 워크
  - EJB가 제공하는 서비스를 지원해 줄 수 있는 프레임워크 등장
  - Hibernate(JPA), JDO, IBatis(MyBatis), Spring

##### POJO + Framework
  - EJB 서버와 같은 거창한 컨테이너가 필요 없음
  - 오픈소스 프레임워크라 사용이 무료
  - 각종 기업용 어플리케이션 개발에 필요한 상당히 많은 라이브러리가 지원
  - 스프링 프레임워크는 모든 플랫폼에서 사용이 가능함
  - 스프링은 웹 분야 뿐만이 아니라 어플리케이션 등 모든 분야에 적용이 가능한 다양한 라이브러리를 가지고 있다.

### Spring Framework

- 엔터프라이즈 급 어플리케이션을 만들기 위한 모든 기능을 종합적으로 제공하는 경량화 된 솔루션이다
- Framework?
  - 뼈대, 구조물
- Spring Framework는 자바로 엔터프라이즈 어플리케이션을 만들 때 포괄적으로 사용하는 프로그래밍 및 Configuration Model을 제공해 주는 Framework로 어플리케이션 수준의 인프라 스트럭쳐를 제공
- 즉, 개발자가 복잡하고 실수하기 쉬운 low level에 신경 쓰지 않고 Business Logic 개발에 전념할 수 있도록 해준다

## Spring Framework의 구조

### Spring 삼각형

엔터프라이즈 어플리케이션 개발 시 복잡함을 해결하는 스프링의 핵심

1. POJO
   - 특정 환경이나 기술에 종속적이지 않은 객체지향 원리에 충실한 자바 객체
   - 테스트하기 용이하며, 객체지향 설계를 자유롭게 적용할 수 있다
2. PSA(Portable Service Abstraction)
   - 환경과 세부기술의 변경과 관계없이 일관된 방식으로 기술에 접근할 수 있게 해주는 설계 원칙
   - 트랜잭션 추상화, OXM 추상화, 데이터 엑세스의 Exception 변환기능.. 등 기술적인 복잡함은 추상화를 통해 low level의 기술 구현 부분과 기술을 사용하는 인터페이스로 분리
   - 예를 들어 데이터베이스에 관계없이 동일하게 적용 할 수 있는 트랜잭션 처리방식
3. IoC/DI
   - DI 는 유연하게 확장 가능한 객체를 만들어 두고 객체 간의 의존관계는 외부에서 다이나믹하게 설정
4. AOP(Aspect Oriented Programming)
   - 관심사의 분리를 통해서 소프트웨어의 모듈성을 향상
   - 공통 모듈을 여러 코드에 쉽게 적용가능

### Spring Framework의 특징

- 경량 컨테이너
  - 스프링은 자바객체를 담고 있는 컨테이너이다
  - 스프링 컨테이너는 이들 자바 객체의 생성과 소멸과 같은 라이플 사이클을 관리
  - 언제든지 스프링 컨테이너로부터 필요한 객체를 가져와 사용할 수 있다
- DI(Dependency Injection - 의존성 지원) 패턴 지원
  - 스프링은 설정 파일이나, 어노테이션을 통해서 객체 간의 의존 관계를 설정할 수 있다.
  - 따라서, 객체는 의존하고 있는 객체를 직접 생성하거나 검색할 필요가 없다

### Spring Framework Module

프레임 워크는 레고다

- 코어와 bean Factory를 밑바탕으로
- AOP, ORM, DAO 등등 필요한 것들을 레고 블럭처럼 쌓아서 사용

### IoC(Inversion of Control, 제어의 역행)

- IoC/DI
- 객체 지향 언어에서 Object간의 연결 관계를 런타임에 결정
- 객체 간의 관계가 느슨하게 연결됨
- IoC의 구현 방법 중 하나가 DI

### DI(Dependency Injection, 의존성 주입)

A라는 클래스와 B라는 클래스가 있을 때, A라는 클래스가 B에 있는 메소드를 써야할 때, A는 B에 의존적이고 B가 없으면 A는 동작할 수 없다.  
의존성 주입은 B라는 객체를 미리 만들어서 A에 넣어주는 식이고, 이러한 B객체를 만들어 주는 컨테이너가 스프링 컨테이너이다.

### IoC 유형

- DI
  - Object에 lookup 코드를 사용하지 않고 컨테이너가 직접 의존 구조를 Object에 설정 할 수 있도록 지정해 주는 방식
  - Object가 컨테이너의 존재 여부를 알 필요가 없음
  - Lookup 관련된 코드들이 Object내에서 사라짐
  - Setter Injection과 Constructor Inject
  - 사용방법
    - setter
    - 생성자
      - 생성자를 이용하는 것이 권장 사항
    - 메소드
- DL

  - 컨테이너가 lookup context를 통해서 필요한 Resource나 Ojbect를 얻는 방식
  - JNDI 이외의 방법을 사용한다면 JNDL 관련 코드를 오브젝트 내에서 일일히 변경해 주어야 함
  - Lookup 한 Object를 필요한 타입으로 Casting 해 주어야 함
  - Naming Exception을 처리하기 위한 로직이 필요
  - 사용 방법
    - JNDI Lookup
      - MVC Connection Pooling 에서 사용

- 객체간 강한 결합

  - 클래스 호출 방식
  - 클래스내에 선언과 구현이 모두 되어있기 때문에 다양한 형태로 변화가 불가능

- 객체간의 강향 결합을 다형성을 통해 낮춤
- 객체간의 강한 결합을 Factory를 통해 결합도를 낮춤
- 객체 간의 강한 결합을 Assembler를 통해 결합도를 낮춤
  - Assembler == Spring

### Container

- 컨테이너란?
  - 객체의 생성, 사용, 소멸에 해당하는 라이프사이클을 담당
  - 라이프사이클을 기본으로 어플리케이션 사용에 필요한 주요 기능을 제공
- 기능
  - 라이플 사이클 관리
  - Depnedency 객체 제공
  - 스레드 관리
  - 기타 어플리케이션 실행에 필요한 환경
- 필요성
  - 비즈니스 로직 외에 부가적인 기능들에 대해서는 독립적으로 관리되도록 하기 위함
  - 서비스 lookup 이나 Configuration에 대한 일관성을 갖기 위함
  - 서비스 객체를 사용하기 위해 각각 Factory 또는 Singleton 패턴을 직접 구현하지 않아도 됨
- 스프링에서 IoC 를 담당하는 컨테이너에는 BeanFactory ApplicationContext가 있음

### Spring 프로젝트 생성

- 인코딩 설정 확인
- Spring Legacy Project
  - MVC
    - pom.xml 수정
    - maven update

root-context.xml

- 모델 관련

servlet-context.xml

- 컨트롤러, 뷰리졸버 등등

aop로 예외처리 가능

- @ControllerAdvice
  - @ExceptionHandler


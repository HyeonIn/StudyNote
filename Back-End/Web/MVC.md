## Web Application Architecture - MVC

### Web Application Architecture

- JSP를 이용하여 구성할 수 있는 Web Application Architecture는 크게 model1과 model2로 나뉜다
- JSP가 클라이언트의 요청에 대한 로직 처리와 응답 페이지에 대한 처리를 모두 하느냐, 아니면 응답 페이지에 대한 처리만 하는지가 가장 큰 차이점 이다
- Model2 구조는 MVC(Model-View-Controller) 패턴을 웹 개발에 도입한 구조를 말한다

#### Model1

- Model1은 view와 logic을 JSP 페이지 하나에서 처리하는 구조
- 클라이언트로부터 요청이 들어오게 되면 JSP 페이지는 java beans나 별도의 service class를 이용하여 작업을 처리, 결과를 클라이언트에 출력
  - java beans?
    - DTO(Data Transfer Object), VO(Value Object)
      - 일반적으로 데이터베이스 내 테이블 단위
    - 테이블 데이터가 아니라면 Map을 활용

##### Model1 구조의 장단점
|장점|단점|
|--|--|
|구조가 단순하며 직관적이기 때문에 배우기 쉽다|출력을 위한 view(html) 코드와 로직 처리를 위한 java 코드가 섞여 있기 때문에 JSP 코드 자체가 복잡해 진다|
|개발 시간이 비교적 짧기 때문에 개발 비용이 감소|JSP코드에 백엔드와 프론트엔드가 혼재되기 때문에 분업이 힘들어진다|
||프로젝트의 규모가 커지게 되면 코드가 복잡해 지므로 유지보수 하기가 어렵다|
||확장성(신기술 도입, framework등..)이 나쁘다|

#### Model2 - MVC Pattern

- 클라이언트 요청에 대한 처리는 Servlet이, 로직 처리는 java class(Service, Dao, ..), 클라이언트에게 출력하는 응답 페이지를 JSP가 담당
- Model2 구조는 MVC 패턴을 웹 개발에 도입한 구조이며 완전히 같은 형태를 보인다

|Model2|MVC Pattern|설명|
|--|--|--|
|Service, Dao or Java Beans|Model|로직(비즈니스 로직, 디비 로직)을 처리하는 모든 것, controller로 부터 넘어온 data를 이용하여 이를 수행하고 그에 대한 결과를 다시 controller에 return 한다|
|JSP|View|모든 화면 처리를 담당. 클라이언트의 요청에 대한 결과 뿐 아니라 controller에 요청을 보내는 화면단도 JSP에서 처리한다. 로직 처리를 위한 자바 코드는 사라지고 결과 출력을 위한 코드(ML)만 존재|
|Servlet|Controller|클라이언트의 요청을 분석하여 로직 처리를 위한 Model을 호출한다. return 받은 결과를 필요에 따라 request, session등에 저장하고, redirect 또는 forward 방식으로 jsp page를 이용하여 출력한다|

##### Model2 구조 흐름 요약

1. 클라이언트의 요청을 서블릿이 받음
2. 로직 처리를 위해 서비스 클래스를 실행함
3. 서비스 클래스의 결과를 Entity 객체에 담음
4. JSP 파일이 Entity 객체를 참조하여 응답 페이지를 만듦
5. 서블릿이 응답 페이지를 사용자에게 보여줌

##### Model2 구조의 장단점
|장점|단점|
|--|--|
|출력을 위한 코드와 로직 처리를 위한 코드가 분리 되었기 때문에 Model1에 비해 JSP 코드가 복잡하지 않다|구조가 복잡하여 초기 진입이 어렵다|
|화면단과 로직단이 분리되었기 때문에 분업이 용이하다|개발 시간의 증가로 개발 비용이 증가|
|기능에 따라 코드가 분리 되었기 때문에 유지보수가 쉽다||
|확장성이 뛰어나다||

Q) 모든 웹사이트는 Model2 구조로만 만드는가?
- 유지보수와 확장성이 크게 중요하지 않은 곳에서는 Model1 구조로 비용을 절감하는 편 
### 10/18 수업

#### DI(Dependency Injection, 의존성 주입)

- 빈(bean) 생성 범위
  - 싱글톤 빈(singleton bean)
    - 스프링 빈은 기본적으로 싱글톤으로 만들어짐
    - 그러므로, 컨테이너가 제공하는 모든 빈의 인스턴스는 항상 동일함


#### AOP(Aspect Oriented Programming, 관점 지향 프로그래밍)


- 위빙


#### MVC with Spring

- 디렉토리 구조
  - resources
    - js, css, img 같은 front 리소스
  - WEB-INF
    - spring
      - appServlet
        - servlet-context.xml
          - Dispatcher Servlet 관련 객체들이 들어감
            - Controller, ViewResolver, FileUpload 같은 객체들
      - root-context.xml
        - 모델 관련 객체들이 들어감
          - Dao, Service 같은 객체들
    - views
      - jsp 파일들
    - web.xml
      - tomcat 서버가 스타트 될 때 읽는 파일
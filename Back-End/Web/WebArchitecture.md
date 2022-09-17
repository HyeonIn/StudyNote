웹브라우저를 띄운다.
클라이언트 프로그램 실행

http 요청을 받을 수 있는 게
두가지가 있음
서블릿이랑 jsp
서블릿은 java파일
html 만들기가 너무 어려움

jsp는 jsp파일
서블릿의 단점을 해결, html 만들기 쉬움
html안에서 자바가 실행되는 느낌
다만, 쓰다보니까 코드가 너무 지저분함
자바가 힘듦

--> 두개 같이 써보자
하고 나온게 MVC(Model, View, Controler) 구조
Model - db
view - jsp
control - servlet


요청을 서블릿으로 받고
java로 처리하는 부분을 전부 서블릿에서 처리하고 (DB 작업 등)
jsp로 html 작성을 넘겨줌 (request, response 넘김)

MVC에서는 절대 JSP로 요청을 보내지 않음

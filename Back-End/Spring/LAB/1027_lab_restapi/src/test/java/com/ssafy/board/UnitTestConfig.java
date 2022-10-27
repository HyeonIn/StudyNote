package com.ssafy.board;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//** JUnit 지원 어노테이션
//@Test
//테스트를 수행하는 메소드를 지정합니다. 
//jUnit에서는 각각의 테스트가 서로 영향을 주지 않고 독립적으로 실행되는 것을 지향합니다. 
//따라서 @Test 단위 마다 필요한 객체를 생성해 지원해줍니다. 
//
//@Ignore
//테스트를 실행하지 않도록 해줍니다. 
//메소드는 남겨두되 테스트에 포함되지 않도록 하려면 이 어노테이션을 붙여두면 됩니다.
//
//@Before / @After
//테스트 메소드가 실행되기 전, 후로 항상 실행되는 메소드를 지정합니다. 
//공통적으로 실행되어야 하는 메소드가 있다면 어노테이션을 붙여주면 됩니다. 각각의 테스트 메소드에 적용됩니다.
//
//@BeforeClass / @AfterClass
//각각의 메소드가 아닌 해당 클래스에서 딱 한번만 수행되는 메소드입니다. 테스트 메소드의 갯수와 상관없이 딱 한번만 실행됩니다.

//Spring-Test 어노테이션
//@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext를 만들고 관리하는 작업을 할 수 있도록 jUnit의 기능을 확장해줍니다. 
//스프링의 핵심 기능인 컨테이너 객체를 생성해 테스트에 사용할 수 있도록 해준다고 보면 됩니다. 원래 jUnit에서는 테스트 메소드별로 객체를 따로 생성해 관리하는 반면, Spring-Test 라이브러리로 확장된 jUnit에서는 컨테이너 기술을 써서 싱글톤으로 관리되는 객체를 사용해 모든 테스트에 사용하게 됩니다.
//
//@ContextConfiguration(locations = "classpath:xml파일위치")
//스프링 빈(Bean) 설정 파일의 위치를 지정할 수 있습니다. 
//굳이 별도로 컨테이너를 추가하지 않고 Bean을 등록해둔 xml 파일을 지정해 컨테이너에서 사용할 수 있도록 해줍니다. 
//위의 @RunWith 어노테이션은 컨테이너를 생성하겠다는 의미인데, 어떤 파일을 참조할지 모르는 상태이기 때문에 이 어노테이션을 함께 써줘야 합니다.
//파일 위치의 루트는 "src/test/resources" 폴더입니다. 필요한 설정 파일은 이곳에 복사해놓고 사용해도 됩니다. 
//하지만 매번 파일을 복사하면 힘들기 때문에 "file:Full path" 형식으로 써주면 운영 개발에서 사용하는 파일을 불러올 수 있습니다. 
//대괄호 { } 를 붙이면 여러개도 모두 가져올 수 있습니다. 
//
//@Autowired
//스프링에서 사용하는 것과 같습니다. 자동으로 의존성 주입을 해줍니다. 

//** method
//assertEquals(x, y)
//	·객체 x와 y가 일치함을 확인합니다.
//	·x(예상 값)와 y(실제 값)가 같으면 테스트 통과
//
//assertArrayEquals(a, b);
//	·배열 A와 B가 일치함을 확인합니다.
//
//assertFalse(x)
//	·x가 false 인지 확인합니다.
//
//assertTrue(x)
//	·x가 true 인지 확인합니다.
//
//assertTrue(message, condition)
//	·condition이  true이면 message표시
//
//assertNull(o)
//	·객체o가 null인지 확인합니다.
//
//assertNotNull(o)
//	·객체o가 null이 아닌지 확인합니다.
//
//assertSame(ox, oy)
//	·객체 ox와 oy가 같은 객체임을 확인합니다.
//	·ox와 oy가 같은 객체를 참조하고 있으면 테스트 통과
//	·assertEquals()메서드는 두 객체의 값이 같은지 확인하고, assertSame()메서드는 두 객체의 레퍼런스가 동일한가를 확인합니다. (== 연산자)
//
//assertNotSame(ox, oy)
//	·ox와 oy가 같은 객체를 참조하고 있지 않으면 통과
//
//assertfail()
//	·테스트를 바로 실패처리

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@WebAppConfiguration
public class UnitTestConfig {

	@Autowired
	public ApplicationContext context;
	
//	@Autowired
//	public WebApplicationContext wac;
	
}

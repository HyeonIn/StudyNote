package model;

public interface IMemberDao {
	int insert(Member member) ; // 회원가입
	Member selectOne(String id, String pw) ; // 로그인
}

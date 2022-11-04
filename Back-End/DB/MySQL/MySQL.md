## MySQL

### RDBMS(Relational DataBase Management System)

- 관계형 데이터베이스 시스템
- 테이블 기반의 DBMS
  - 데이터를 테이블 단위로 관리
    - 하나의 테이블은 여러개의 컬럼으로 구성
  - 중복 데이터를 최소화 시킴
    - 같은 데이터가 여러 컬럼 또는 테이블에 존재 했을 경우 데이터를 수정 시 문제가 발생할 가능성이 높아짐. > 정규화
  - 여러 테이블에 분산되어 있는 데이터를 검색 시 테이블 간의 관계를 이용하여 필요한 데이터를 검색
  
### SQL(Structured Query Language)

- Database에 있는 정보를 사용할 수 있도록 지원하는 언어
- 모든 DBMS에서 사용 가능
- 대소문자는 구별하지 않음 (단, 데이터의 대소문자는 구분)

#### DDL(Data Definition Language)

- 데이터 정의어
  - 데이터 베이스 객체의 구조를 정의
  - 테이블 생성, 컬럼 추가, 타입 변경, 제약조건 지정, 수정 등
- SQL 문
  - create
    - 데이터베이스 객체를 생성
  - drop
    - 데이터베이스 객체를 삭제
  - alter
    - 기존에 존재하는 데이터베이스 객체를 수정

#### DML(Date Manipulation Language)

- 데이터 조작어
  - 데이터 조작 기능
  - 테이블의 레코드를 CRUD (Create, Retrieve, Update, Delete)
- SQL 문
  - insert(C)
    - 데이터베이스 객체에 데이터를 입력
  - select(R)
    - 데이터베이스 객체에서 데이터를 조회
  - update(U)
    - 데이터베이스 객체에 데이터를 수정
  - delete(D)
    - 데이터베이스 객체에 데이터를 삭제

#### DCL(Data Control Language)

- 데이터 제어어
  - DB, Table의 접근권한이나 CRUD 권한을 정의
  - 특정 사용자에게 테이블의 검색권한 부여/금지 등
- SQL 문
  - grant
    - 데이터베이스 객체에 권한을 부여
  - revoke
    - 데이터베이스 객체 권한 취소

#### TCL(Transaction Control Language)

- 트랜잭션 제어어
  - 트랜잭션이란 데이터베이스의 논리적 연산 단위
- SQL 문
  - commit
    - 실행한 쿼리를 최종적으로 적용
  - rollback
    - 실행한 쿼리를 마지막 커밋전으로 취소시켜 데이터를 복구
  
// 13 page부터 다시 시작

#### View
select문에 이름 붙여서 가상의 테이블처럼 사용
- 자주 사용하는 join을 마치 테이블인 것처럼 문법적으로 편하게 사용 가능
- 전체 테이블 데이터를 다 쓰는게 아닌 부분적으로만 오픈할 수 있어서 권한제어 가능
- view를 이용한 데이터 insert, update, delete 등을 주의해야 함

#### Index
where 조건에 자주 사용되는 컬럼에 대해 정렬된 목차를 만들어 두는 것
- 장점 
  - 조회속도 향상
- 단점 
  - 레코드의 약 10% 가량의 저장공간 필요함
  - 인덱스 생성에도 초기 시간이 필요함
  - 데이터 변경이 잦은 테이블일 경우, 인덱스도 매번 같이 영향 받아야 함
  - 데이터의 중복이 적은 컬럼이어야 효율적임



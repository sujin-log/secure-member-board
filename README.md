# secure-member-board

Spring Boot 기반의 회원 관리 및 게시판 프로젝트입니다.

기본적인 웹 기능을 구현하고, 인증·인가 및 접근 제어를 통해 웹 애플리케이션에서 발생할 수 있는 보안 취약점을 예방하는 데 중점을 두었습니다.

## 개발 환경

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Gradle

## 주요 기능

- 회원가입 및 로그인
- 회원 정보 조회 및 관리
- 게시글 작성, 조회, 수정, 삭제
- 사용자 권한에 따른 기능 접근 제어
- 입력값 검증 및 예외 처리

## Security

### Authentication
- Spring Security 기반 인증 구조 구성
- BCrypt를 이용한 비밀번호 해시 처리
- 비밀번호 평문 저장 방지

### Authorization & Access Control
- 사용자 권한에 따른 API 접근 제어
- 게시글 작성자 확인을 통한 수정·삭제 권한 검증
- 관리자 전용 기능에 대한 권한 검증

### Vulnerability Prevention
- **IDOR:** 게시글 ID 변경을 통한 타 사용자 데이터 접근 방지
- **Broken Access Control:** 권한이 없는 사용자의 기능 접근 차단
- **Input Validation:** 이메일 형식, 필수 입력값, 제목 길이 검증
- **Exception Handling:** 중복 이메일 및 존재하지 않는 게시글에 대한 예외 처리

## Security Testing

- 게시글 ID 변경을 통한 비인가 데이터 접근 테스트
- 타 사용자 게시글 수정 및 삭제 요청 검증
- 일반 사용자 계정의 관리자 API 접근 테스트
- 잘못된 입력값 및 중복 이메일 처리 확인

## 프로젝트 목적

회원 관리와 게시판 기능을 구현하면서 웹 애플리케이션의 인증·인가 구조와 접근 제어 방식을 이해하고, 주요 보안 취약점을 예방하는 방법을 익히는 프로젝트입니다.

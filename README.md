# CourtFinder

<p>[환경설정]</p>
https://spring.io/tools/ &nbsp;&nbsp;&nbsp; WINDOW x86 64 version download

<p>[프로젝트 생성시 의존성 설정]</p>
Spring JPA, Spring Web, Spring devtools, MySQL driver, Lombok, Thymeleaf


명령 프롬프트에서 위 파일 저장된 디렉토리로 이동 예) cd C:\devTools<br>
이동 후 java -jar 파일명.jar 입력으로 압축풀기<br>

압축 풀어진 파일에서 exe 확장자 프로그램 실행<br>

JSP와 Javascript 사용 환경을 위해 Eclipse Marketplace에서 Eclipse Enterprise Java and Web Developer Tools 3.31 설치<br>
이로 인하여 jsp파일과 javascript 파일을 사용 가능

<p>[MYSQL 설정]</p>
create user 'court'@'%' identified by '12345!';
GRANT ALL PRIVILEGES ON *.* TO 'court'@'%';
CREATE DATABASE court CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

<p>Thyemleaf 템플릿 엔진 설정</p>
JSP와 JSTL 대신에 Thymeleaf 활용위해 의존성 추가
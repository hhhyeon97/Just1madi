<div align=center>
<h1>memoong 🗯️</h1>
<h3>나만의 메모장 memoong을 소개합니다 !</h3>
</div>

<br>

<H3>⚙️ 환경 설정</H3>

- **IDE :** Spring Tool Suite (STS) 4.21.0
- **서버 :** Apache Tomcat 10.1.17
- **데이터베이스 :** Oracle 21
- **데이터베이스 클라이언트 :** SQL Developer 19.2.1
- **자바 개발 키트 :** JDK 17
- **프레임워크 :** Spring Boot


<H3>🛠️ 기술 스택</H3>

- **Spring 프레임워크 :**
  - Spring Security
  - Spring Data JPA
  - Spring MVC

- **웹 개발 :**
  - JSTL
  - AJAX

- **프론트엔드 :**
  - HTML
  - CSS
  - JavaScript
<br>
 
## 프로젝트 실행 방법

1. clone 후 IDE에서 프로젝트를 엽니다.
2. 데이터베이스 연결 설정을 확인하고 필요한 경우 수정합니다.
3. Boot Dashboard에서 프로젝트를 시작합니다.
4. 브라우저에서 `localhost:포트번호`로 접속하여 확인합니다.


## 데이터베이스 설정

memoong 프로젝트에서는 Oracle 21 데이터베이스를 사용하였습니다.<br>
아래는 데이터베이스 연결에 필요한 정보입니다.

- **데이터베이스 버전 :** Oracle 21
- **데이터베이스 사용자명 :** potato
- **데이터베이스 비밀번호 :** 123456
- **데이터베이스 주소 :** jdbc:oracle:thin:@localhost:1521:xe<br>

### 데이터베이스 계정 생성 스크립트

프로젝트에서 사용하는 데이터베이스 계정을 생성하기 위한 SQL 스크립트입니다.

```sql
CREATE USER [사용자명] IDENTIFIED BY [비밀번호];
GRANT CONNECT, RESOURCE TO [사용자명];
```
<br>

## 🎥 시연 gif

![메뭉시연01](https://github.com/hhhyeon97/memoong/assets/148893126/3eca08da-3a47-4174-9183-2870797ee618)



## 주요 기능

### 📃 로그인/회원가입

<br>

![화면 캡처 2024-01-11 230654](https://github.com/hhhyeon97/memoong/assets/148893126/56c2654b-c2fa-4b73-8a9a-06433593c99d)
![화면 캡처 2024-01-11 230608](https://github.com/hhhyeon97/memoong/assets/148893126/0bdab91d-5455-4431-b164-d9c508ae47b0)

<br>

**로그인**  <br/>

목적: 사용자가 앱에 접근하고 자신의 계정에 로그인할 수 있습니다.<br/>

동작:<br/>
- 사용자는 유효한 계정 정보(닉네임, 비밀번호)를 입력합니다.
- 시스템은 입력된 정보를 검증하고, 올바른 경우 사용자를 로그인 상태로 전환합니다.
- 잘못된 정보인 경우, 사용자에게 오류 메시지를 제공합니다.

**회원가입**  <br/>

목적: 새로운 사용자가 앱에 계정을 생성할 수 있습니다.<br/>

동작:<br/>
- 사용자는 필요한 정보(닉네임, 비밀번호)를 입력하여 회원가입을 요청합니다.
- 시스템은 입력된 정보를 검증하고, 유효한 경우 새로운 계정을 생성합니다.
- 이미 존재하는 닉네임인 경우, 사용자에게 중복 방지 메세지를 제공합니다.
- 사용자가 1234와 같은 간단한 비밀번호로 가입을 해도 시큐리티 설정으로<BR>
  비밀번호를 암호화된 패턴으로 DB에 저장하여 보안을 강화합니다.

 <br/>

### 📃 메모장 CRUD 기능

<br/>

![화면 캡처 2024-01-11 233204](https://github.com/hhhyeon97/memoong/assets/148893126/8c465f22-b852-4d96-b71c-f87c8fc9edd9)
![화면 캡처 2024-01-11 235015](https://github.com/hhhyeon97/memoong/assets/148893126/78a86ae8-18e1-49bb-964b-dcb252c73550)

![화면 캡처 2024-01-11 233230](https://github.com/hhhyeon97/memoong/assets/148893126/46a89b02-dff3-49a9-a7e0-82acd4af3900)
![화면 캡처 2024-01-11 233320](https://github.com/hhhyeon97/memoong/assets/148893126/a56e1507-5d6c-4389-aaf8-6e11a9d1a5de)

<br>

**메모 작성**

목적: 사용자가 새로운 메모를 작성할 수 있습니다.<br>

동작:<br>

- 사용자는 메모할 내용을 입력하여 새로운 메모를 작성합니다.<br>
- 시스템은 작성된 메모를 저장하고 메모 목록 화면으로 이동하게 합니다.<br>

<br>

**메모 조회**

목적: 사용자는 작성된 메모 목록을 확인할 수 있습니다.<br>

동작:<br>

- 사용자는 앱 내에서 자신이 작성한 메모들을 리스트로 확인합니다.<br>
- 각 메모의 내용은 10글자 이상일 때 ...을 붙여 보여주고 해당 내용을 클릭할 시<br>
  작성한 날짜와 해당 메모의 전체 내용을 확인할 수 있습니다.<br>

<br>

**메모 수정**

목적: 사용자가 이전에 작성한 메모를 수정할 수 있습니다.<br>

동작:<br>

- 사용자는 원하는 메모를 선택하고 내용을 수정합니다.<br>
- 시스템은 수정된 내용을 저장하고 메모 목록으로 이동하게 합니다.<br>

<br>

**메모 삭제**

목적: 사용자가 더 이상 필요하지 않는 메모를 삭제할 수 있습니다.<br>

동작:<br>

- 사용자는 삭제하고자 하는 메모를 선택하여 삭제 요청을 합니다.<br>
- 시스템은 해당 메모를 삭제할 때 한 번 더 삭제할 지 알림창을 띄워 알려줍니다.<br>


### 📃 회원정보 수정 기능
<br>

![화면 캡처 2024-01-11 233343](https://github.com/hhhyeon97/memoong/assets/148893126/5c8fd9ed-8129-4bd8-ad2d-adacd18c718d)


목적: 사용자가 자신의 계정 정보를 수정할 수 있습니다.<br>

동작:<br>

- 사용자는 기존에 등록한 정보 중 비밀번호를 수정할 수 있습니다.<br>
- 시스템은 수정된 정보를 검증하고, 유효한 경우 계정 정보를 업데이트합니다.<br>
- 사용자에게 수정 성공 메시지를 제공하며 업데이트한 정보로 로그인을 다시 요청합니다.<br>


## 기타 문서

### **1. MVP**

- **프로젝트 소개**

memoong 프로젝트는 사용자가 메모를 작성하고 관리할 수 있는 간단한 웹사이트입니다. 

사용자는 기본적으로 로그인/회원가입 기능을 통해 사이트를 이용할 수 있고

메모를 추가, 수정, 삭제하고 목록을 볼 수 있습니다.

- **핵심 기능**

1. **로그인/회원가입** : 사용자는 닉네임, 패스워드 항목을 기입하여 간단한 회원가입 및 로그인을 할 수 있습니다.
2. **메모 작성 :** 사용자는 웹 어플리케이션을 통해 텍스트 기반의 메모를 작성할 수 있습니다.
3. **메모 목록 보기 :** 사용자는 작성한 메모의 목록을 확인할 수 있습니다.
4. **메모 수정 및 삭제 :** 사용자는 작성한 메모를 수정하거나 삭제할 수 있습니다.
5. **회원 정보 수정** : 사용자는 패스워드를 수정할 수 있습니다.

 **프로젝트 구성**

- 로그인 페이지 (메인 화면)
- 회원가입 페이지
- 메모 작성 페이지
- 메모 목록 페이지
- 메모 상세보기 페이지
- 메모 수정 페이지
- 회원 정보 변경 페이지

 **향후 계획**

- **모바일 최적화 작업** : 반응형 고려하여 수정 진행하기
- **메모 검색 기능 :** 메모 내용을 검색할 수 있는 기능 추가 예정


### **2. ERD**

![화면 캡처 2024-01-11 225046](https://github.com/hhhyeon97/memoong/assets/148893126/1a96c733-6cc1-45cf-9967-d38ac81a207d)



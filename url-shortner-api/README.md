## Step 3. URL Shortner Ticket

티켓 서버는 고유 번호를 관리하는 서버입니다.  
분산 시스템을 위한 유일 고유 번호 생성기입니다.  
단축 서버에서 요청하면 고유 번호를 발급해줍니다.

## 실행하는 법
```bash
$ ./gradlew clean build
$  java -jar url-shortner-api/build/libs/url-shortner-api-XXX.jar
```

## IDE에서 Lombok 어노테이션 처리 활성화

IntelliJ IDE 에서 어노테이션 처리 활성화해야 Lombok 플러그인이 동작합니다.

![스크린샷 2023-12-11 오전 4 03 49](https://github.com/kor-Chipmunk/ProfileLinkService/assets/16275188/5e1a4473-c37b-4b2b-ba15-2bfea0519ccc)


## 시퀀스 다이어그램

```mermaid
sequenceDiagram
    Client->>+URL Shortner API: 원래 주소로 단축 주소 생성 요청
    URL Shortner API-->>-Client: 단축 주소 전달
    Other Clients->>+URL Shortner API: 단축 주소로 원래 주소로 리다이렉션 요청
    URL Shortner API-->>-Other Clients: 원래 주소로 리다이렉션
    URL Shortner API-->>+Ticket Server: 고유 번호 발급 요청
    Ticket Server-->>-URL Shortner API: 고유 번호 발급 
```

## 아키텍처

![스크린샷 2023-12-13 오전 7 39 17](https://github.com/kor-Chipmunk/ProfileLinkService/assets/16275188/66ffc1be-47bc-4a31-948c-ee79c8c699f7)

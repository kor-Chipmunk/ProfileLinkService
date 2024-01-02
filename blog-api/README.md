## Step 4. Simple Blog

프로필 링크 페이지를 만듭니다.  
블럭들을 만들고, 수정하고, 삭제합니다.  
한 페이지에 프로필 블럭, 텍스트 블럭, 미디어 블럭, 링크 블럭, SNS 블럭을 편집합니다.  


## 실행하는 법
```bash
$ ./gradlew clean build
$  java -jar blog-api/build/libs/blog-api-XXX.jar
```

## IDE에서 Lombok 어노테이션 처리 활성화

IntelliJ IDE 에서 어노테이션 처리 활성화해야 Lombok 플러그인이 동작합니다.

![스크린샷 2023-12-11 오전 4 03 49](https://github.com/kor-Chipmunk/ProfileLinkService/assets/16275188/5e1a4473-c37b-4b2b-ba15-2bfea0519ccc)


## 시퀀스 다이어그램

```mermaid
sequenceDiagram
    User->>+Blog Server: 페이지 생성 요청
    Blog Server-->>-User: 페이지 응답
    User->>+Blog Server: 페이지 수정 요청
    Blog Server-->>-User: 페이지 응답
```

## 아키텍처

![스크린샷 2024-01-02 오후 5 06 16](https://github.com/kor-Chipmunk/ProfileLinkService/assets/16275188/103586cb-d761-4c41-86dc-f92fbbfa9729)


## Domain Class DIagram

```mermaid
classDiagram
    Block <|-- BlockProfile
    Block <|-- BlockLink
    Block <|-- BlockText
    Block <|-- BlockMedia
    Block <|-- BlockSNSConnection

    Page <-- Block
    
    class Page {
        +MainBaseText name;
        +BlockProfile profile;
        +List<Block> blocks;
    }

    class Block {
    }
    
    class BlockProfile {
        +MainBaseText main
        +SubBaseText sub
        +Image profileImage
    }
    
    class BlockLink {
        +TitleBaseText title
        +Link link
        +Image image
    }
    
    class BlockText {
        +TitleBaseText title
        +ContentBaseText content
    }
    
    class BlockMedia {
        +TitleBaseText title;
        +Link link
    }
    
    class BlockSNSConnection {
        +InstagramText instagram
        +TelephoneText telephone
    }
```

## Step 1. URL Shortner Simple

현재 버전은 원래 주소를 받아 단축 주소를 만들어주는 서버와 통신합니다.  
만든 단축 주소를 표시합니다.

## 데모

![화면 기록 2023-12-11 오전 3 33 40](https://github.com/kor-Chipmunk/ProfileLinkService/assets/16275188/f18ec633-8a2f-44a8-9ba8-6091fc7a35db)

## 시작하기

개발 서버를 실행합니다.

```bash
npm run dev
# or
yarn dev
# or
pnpm dev
# or
bun dev
```

브라우저에서 [http://localhost:3000](http://localhost:3000) 주소에 접속합니다.

## 프로젝트 구조 설명

Next.JS 기반 프로젝트입니다.

- API 호출
  - `src/api/core` : 공통 Axios 클라이언트를 제공합니다.
  - `src/api/**` : 백엔드 서버와 API 인터페이스를 제공합니다.
- UI 화면
  - `src/app` : 기본 페이지입니다.
  - `src/components/uis` : 순수 UI 컴포넌트입니다. 기본으로 `Material UI`를 사용합니다.
  - `src/components/domains` : 비즈니스 도메인이 담긴 컴포넌트입니다.
  - `src/pages` : 페이지 화면을 제공합니다.
- 타입
  - `src/types/**` : 프로젝트 내에 쓰이는 공통 타입을 정의합니다.

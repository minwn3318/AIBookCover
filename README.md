# 창작 도서 관리 시스템 "걷기가 서재" (백엔드)
> **프론트엔드 깃허브 링크** : [https://github.com/bookfront/bookmuseum]

## 1. 프로젝트 소개
걷기가 서재의 “작가의 산책” 서비스는 누구나 작가가 되어 자유롭게 글을 집필하고 공개할
수 있는 창작 플랫폼 입니다. 본 깃허브 프로젝트는 걷기가 서재의 로그인, 도서등록, 이미지 생성 등의 서비스를 제공하는 서버단을 담당하고 있습니다

## 2. 주요 기능
- 회원가입/로그인/ 로그아웃
- 창작 도서 생성/수정/삭제
- 전체 도서 조회 / 인기 도서 조회 서비스
- 댓글 / 좋아요 
- AI 책 표지 생성 / 수정 
   
## 3. 기술 스택
- SpringBoots
- RESTful API
- Spring Security
- Cookie & JWT
- H2-console
- JPA Repository

## 4. 시스템 아키텍처 구조
<대에에충 아키텍처 이미지 모습, 브라우저 -> 리엑트 -> 에이아이, 스프링부트 >   
 
## 5. 프로젝트 디렉터리 <간략>
```
src
└── main
    └── java
        └── com.example.demo
            ├── config
            │   └── WeConfig.java
            ├── configuration
            │   └── SecurityConfig.java
            ├── controller
            │   ├── BookController.java
            │   ├── CommentController.java
            │   ├── MemberController.java
            │   └── MypageController.java
            ├── domain
            │   ├── Book.java
            │   ├── Comment.java
            │   ├── Likes.java
            │   └── Member.java
            ├── dto
            ├── exception
            │   └── GlobalExceptionHandler.java
            ├── repository
            ├── security
            └── service
```
## 7. 주요 API 명세 
### Book API 목록
| 기능              | Method     | Endpoint                        | 설명                            |
| --------------- | ---------- | ------------------------------- | ----------------------------- |
| 도서 등록           | **POST**   | `/api/books`                    | Book 생성                       |
| 도서 전체 목록 조회     | **GET**    | `/api/books`                    | 모든 도서 조회                      |
| 인기 도서 조회        | **GET**    | `/api/books/hot`                | 조회수 기준 인기 도서                  |
| 도서 상세 조회        | **GET**    | `/api/books/{bookId}`           | 특정 도서 조회 + viewCnt 증가         |
| 도서 수정           | **PUT**    | `/api/books/{bookId}`           | 해당 bookId 수정                  |
| 도서 삭제           | **DELETE** | `/api/mypage/{bookId}`          | 마이페이지에서 등록자가 자신의 도서 삭제        |
| 좋아요 / 좋아요 취소    | **PATCH**  | `/api/books/{bookId}`           | 로그인 사용자만 가능, liked/unliked 반환 |
| 책 커버 이미지 URL 저장 | **PUT**    | `/api/books/{bookId}/cover-url` | 생성된 이미지 URL 저장                |

### Comment API 목록
| 기능       | Method     | Endpoint                       | 설명           |
| -------- | ---------- | ------------------------------ | ------------ |
| 댓글 등록    | **POST**   | `/api/books/{bookId}/comments` | 해당 도서에 댓글 추가 |
| 댓글 목록 조회 | **GET**    | `/api/books/{bookId}/comments` | 해당 도서의 모든 댓글 |
| 댓글 수정    | **PUT**    | `/api/comments/{commentId}`    | 댓글 내용 수정     |
| 댓글 삭제    | **DELETE** | `/api/comments/{commentId}`    | 본인 댓글만 삭제 가능 |

### Member API 목록
| 기능   | Method   | Endpoint            | 설명         |
| ---- | -------- | ------------------- | ---------- |
| 회원가입 | **POST** | `/api/member`       | 새로운 사용자 생성 |
| 로그인  | **POST** | `/api/member/login` | JWT 토큰 발급  |

### MyPageAPI 목록
| 기능               | Method     | Endpoint               | 설명                 |
| ---------------- | ---------- | ---------------------- | ------------------ |
| 내가 등록한 도서 조회     | **GET**    | `/api/mypage`          | 로그인한 사용자가 등록한 책 목록 |
| 내가 좋아요한 도서 목록 조회 | **GET**    | `/api/mypage/liked`    | 좋아요 누른 책 목록        |
| 도서 삭제            | **DELETE** | `/api/mypage/{bookId}` | 내가 등록한 책만 삭제 가능    |

## 8. 프로젝트 설계 문서 링크 (optional)
## 9. 개발 진행중 배운 점 및 개선점 (optional)

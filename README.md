flowchart TD
%% Client가 API 호출
A[Client 요청<br/>(Access Token 포함)] --> B{API-Gateway<br/>토큰 검증}

%% Access Token 유효 분기
B -- 유효 --> C[Resource 서버로 전달<br/>요청 처리 → 200 OK]

%% Access Token 만료 분기
B -- 만료 --> D[401 Unauthorized<br/>("Access Token expired")]

%% Refresh 흐름 시작
D --> E[Client: /refresh 엔드포인트 호출<br/>(Refresh Token 전송)]
E --> F{User Service<br/>Refresh 토큰 검증}

%% Refresh Token 유효
F -- 유효 --> G[새 Access/Refresh Token 발급]
G --> H[Client에 새 토큰 응답]
H --> A  %% 원래 요청 재시도

%% Refresh Token 만료
F -- 만료/무효 --> I[401 Unauthorized<br/>("Refresh Token expired")]
I --> J[Client → 로그인 페이지로 리디렉션]

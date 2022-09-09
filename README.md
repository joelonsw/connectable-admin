### Connectable 어드민

## Frontend
- [x] 로그인
- [x] OrderDetail 조회
- [x] OrderDetail 상세 조회
- [x] OrderDetail 입금 확인 버튼
- [x] OrderDetail 입금 안 됨 버튼
- [x] OrderDetail 환불 버튼

## Backend
- [x] 로그인을 할 수 있다
  - [x] 로그인은 JWT 토큰을 통해 관리한다
  - [x] 로그인을 제외한 모든 요청은 인터셉터에서 토큰 검사를 진행한다
- [x] OrderDetail 전체에 대한 정보를 조회를 할 수 있다
- [x] 티켓 Id에 대한 정보를 조회할 수 있다
- [x] 유저 Id에 대한 정보를 조회할 수 있다
- [x] 주문이 들어온 OrderDetail에 대해 입금 확인 절차를 서비스 단에 요청할 수 있다
  - [x] JWT 토큰을 통해 어드민 인지를 확인한다
- [x] NFT 민팅 기능을 제공한다

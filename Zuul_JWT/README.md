# postman 테스트 방법

### id, pw 로그인
패스워드는 1234일 경우만 로그인 성공, 나머지는 실패이다.
![zuul_로그인](https://user-images.githubusercontent.com/58652419/212009113-cc0a9057-388b-476d-85a4-bf5da89ca2b4.png)

### jwt 토큰 인증
토큰을 보내고 body 값으로 'bpp'가 출력되면 인증 성공이다.
![zuul_인가](https://user-images.githubusercontent.com/58652419/212009067-c8b1754f-3f2b-4dff-b84e-31aa64c08f2c.png)

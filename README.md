# socket-noti

1. 웹소켓을 위한 디펜던시 추가

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>

2. TextWebSocketHandler 을 상속해서  3개 메서드 오버라이드 한 클래스 생성
 1) afterConnectionEstablished  //연결 완료후 실행되는 메서드
 2) handleTextMessage  // 메시지 오면 실행되는 메서드
 3) afterConnectionClosed 연결 종료후 실행되는 메서드
 
 
 3. WebSocketConfigurer 을 구현한 설정클래스 생성 
 
   1) 1registerWebSocketHandlers 메서드 오버라이드1 
   2) 소스 내의 메서드 내용 확인할것.
      .addHandler(webSocketService,"ws") 의 "ws"가 연결 요청 path임  ("ws://localhost:8080/ws") 이런식으로 url이 형성됨.
      
 4. js단 웹소켓 연결 
        const ws = new WebSocket("ws://localhost:8080/ws");

        ws.onopen = function(msg){}  //연결시 실행되는 함수 
        ws.onmessage = function(msg){} //메시지 올때 실행되는 함수
        ws.onclose = function(msg){} //연결 종료시 실행되는 함수
      
      자세한것은 소스 참고할것. 
      이 소스중 access-from-backend 브랜치에서는 backend 단에서 handleTextMessage 에 접근하는 방법도 다루고있다.
    
    

package com.care.root;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TestSocket extends TextWebSocketHandler {

	ArrayList<WebSocketSession> auth = new ArrayList<>();
	@Override //클라이언트가 연결시 실행되는 메소드
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId()+"님 연결되었습니다.");
		auth.add(session);
	}

	@Override //메세지 받는 메소드
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//session은 사용자 정보
		System.out.println(session.getId()+"님 메시지: "+message.getPayload());
		System.out.println("session : "+session.getAttributes());
		Map<String, Object> map = session.getAttributes();
		TextMessage text = new TextMessage(map.get("nick")+" : "+message.getPayload());
		for(WebSocketSession s : auth) {
			s.sendMessage(text);
		}
		//session.sendMessage(message);
	}

	@Override //연결이 끊어지면 실행됨.
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId()+"님 연결 해제");
		
	}

}

package com.javaframwork;

public class ChatResponseDto {

	
	private String content;
	private String sender;
	private MessageType type;
    private String ress;



	public enum MessageType {
		CHAT, LEAVE, JOIN
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getRess() {
		return ress;
	}
	public void setRess(String ress) {
		this.ress = ress;
	}
	
	
	
}

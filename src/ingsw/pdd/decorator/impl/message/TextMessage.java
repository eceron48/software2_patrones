package ingsw.pdd.decorator.impl.message;

public class TextMessage implements IMessage{
	
	private String content;
	public TextMessage (String content) {
		this.content=content;
	}
	@Override
	public IMessage processMessage() {
		
		return this;
	}
	@Override
	public String getContent() {
		
		return content;
	}
	@Override
	public void setContent(String content) {
		this.content=content;
		
	}
	

}

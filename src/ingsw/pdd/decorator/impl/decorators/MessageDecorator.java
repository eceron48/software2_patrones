package ingsw.pdd.decorator.impl.decorators;

import ingsw.pdd.decorator.impl.message.IMessage;

public abstract class MessageDecorator implements IMessage {
protected IMessage message;	


public MessageDecorator(IMessage message) {
	this.message = message;
 }

 @Override
 public void setContent(String content) {
 message.setContent(content);
}

 @Override
 public String getContent() {
 return message.getContent();
 }
}

package org.contourdynamics.cms.producers;

import org.apache.deltaspike.core.api.message.MessageBundle;
import org.apache.deltaspike.core.api.message.MessageTemplate;

@MessageBundle
public interface  CDMessages {
	 @MessageTemplate("Please enter the password")
	 String PasswordRequired();
	 
	 @MessageTemplate("Please Enter Username")
	 String UsernameRequired();
	 
	 @MessageTemplate("Password or Username not Valid!")
	 String LoginStatusFailure();
}

package com.libertymutual.goforcode.youniversity.models;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSMessage {

	    // Find your Account Sid and Auth Token at twilio.com/console
	    public static final String ACCOUNT_SID = "ACf473ec38d11a5d6b2753dd6ca9e775fe";
	    public static final String AUTH_TOKEN = "your_auth_token";

	    public static void createMessage(int phoneNumber) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message
	            .creator(new PhoneNumber("+14159352345"), // to
	                     new PhoneNumber("+16038330253"), // from
	                     "Where's Wallace?")
	            .create();

	        System.out.println(message.getSid());
	    }
}
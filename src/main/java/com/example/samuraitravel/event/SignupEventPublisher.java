package com.example.samuraitravel.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.samuraitravel.entity.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SignupEventPublisher {
	private final ApplicationEventPublisher applicationEventPublisher;
	
	public void publishSignupEvent(User user, String requestUrl) {
		applicationEventPublisher.publishEvent(new SignupEvent(this, user, requestUrl));
	}
}

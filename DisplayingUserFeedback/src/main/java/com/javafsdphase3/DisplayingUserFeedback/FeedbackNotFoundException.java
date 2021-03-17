package com.javafsdphase3.DisplayingUserFeedback;

public class FeedbackNotFoundException extends RuntimeException {
	FeedbackNotFoundException (Long id) {
		super("Could not find feedback associated with id: " + id);
	}
}

package com.javafsdphase3.DisplayingUserFeedback;

import org.springframework.data.jpa.repository.JpaRepository;

interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}


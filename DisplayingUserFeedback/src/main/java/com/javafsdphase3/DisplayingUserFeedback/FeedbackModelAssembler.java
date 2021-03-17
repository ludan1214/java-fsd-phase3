package com.javafsdphase3.DisplayingUserFeedback;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class FeedbackModelAssembler implements RepresentationModelAssembler<Feedback, EntityModel<Feedback>> {
	@Override
	public EntityModel<Feedback> toModel(Feedback employee) {
		return EntityModel.of(employee, //
			linkTo(methodOn(FeedbackController.class).one(employee.getId())).withSelfRel(),
			linkTo(methodOn(FeedbackController.class).all()).withRel("feedback"));
	}
}

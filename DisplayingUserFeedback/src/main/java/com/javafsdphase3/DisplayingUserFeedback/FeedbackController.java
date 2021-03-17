package com.javafsdphase3.DisplayingUserFeedback;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FeedbackController {

  private final FeedbackRepository repository;
  private final FeedbackModelAssembler assembler;

  FeedbackController(FeedbackRepository repository, FeedbackModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/feedback")
  CollectionModel<EntityModel<Feedback>> all() {
    List<EntityModel<Feedback>> feedback_list = repository.findAll().stream()
    	.map(assembler::toModel)
    	.collect(Collectors.toList());
    return CollectionModel.of(feedback_list, linkTo(methodOn(FeedbackController.class).all()).withSelfRel());
  }
  // end::get-aggregate-root[]

  @PostMapping("/feedback")
  Feedback newFeedback(@RequestBody Feedback newFeedback) {
    return repository.save(newFeedback);
  }

  // Single item
  
  @GetMapping("/feedback/{id}")
  EntityModel<Feedback> one(@PathVariable Long id) {

    Feedback feedback = repository.findById(id) //
        .orElseThrow(() -> new FeedbackNotFoundException(id));

    return assembler.toModel(feedback);
  }

  @PutMapping("/feedback/{id}")
  Feedback replaceFeedback(@RequestBody Feedback newFeedback, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(Feedback -> {
        Feedback.setUsername(newFeedback.getUsername());
        Feedback.setMessage(newFeedback.getMessage());
        return repository.save(Feedback);
      })
      .orElseGet(() -> {
        newFeedback.setId(id);
        return repository.save(newFeedback);
      });
  }

  @DeleteMapping("/feedback/{id}")
  void deleteFeedback(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
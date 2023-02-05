package com.zckennedy.ApiFrame.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zckennedy.ApiFrame.Data.ExampleRepository;
import com.zckennedy.ApiFrame.Model.ExampleModel;



@RestController
@RequestMapping("/api/example")
public class ExampleController {
	
	@Autowired
	private ExampleRepository repo;
	
	@GetMapping("/all")
	public List<ExampleModel> findAll() {
		System.out.println("**CUSTOM COMMENT** Returning all ExampleModel objects!");
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExampleModel> findExampleModelById(@PathVariable(value = "id") Long id) {
		Optional<ExampleModel> exampleOptional = repo.findById(id);
		
		if (exampleOptional.isPresent()) {
			System.out.println("**CUSTOM COMMENT** Returning ExampleModel objects that has ID = " + id);
			return ResponseEntity.ok().body(exampleOptional.get());
		} else {
			System.out.println("**CUSTOM COMMENT** ExampleModel with ID = " + id + " is not present in the JPA repository!");
			throw new ExampleModelNotFound("Example model object with id = " + id + " not found in Example repository");
		}
	}
	
	@PostMapping
	public ExampleModel saveExampleModel(@RequestBody ExampleModel exampleModel) {
		System.out.println("**CUSTOM COMMENT** Saving " + exampleModel.toString() + " to the JPA repository!");
		return repo.save(exampleModel);
	}

}

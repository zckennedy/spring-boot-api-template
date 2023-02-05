package com.zckennedy.ApiFrame.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zckennedy.ApiFrame.Model.ExampleModel;


@Repository
public interface ExampleRepository extends JpaRepository<ExampleModel, Long> {}

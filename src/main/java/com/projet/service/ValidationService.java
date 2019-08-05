package com.projet.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface ValidationService {
	ResponseEntity<?> mapValidationService(BindingResult result);
 }

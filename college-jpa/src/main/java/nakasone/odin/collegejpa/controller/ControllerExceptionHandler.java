package nakasone.odin.collegejpa.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Map<String, Object>> handleNoSuchElementExceptio(NoSuchElementException n, WebRequest request){
		Map<String, Object> body = new HashMap<>();
		//body.put("studentId", n.)
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}

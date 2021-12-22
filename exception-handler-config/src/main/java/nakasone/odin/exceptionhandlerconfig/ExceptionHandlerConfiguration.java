package nakasone.odin.exceptionhandlerconfig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerConfiguration extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NeuNotAuthorizedException.class)
	protected ResponseEntity<ResponseBody> handleCustomException(NeuNotAuthorizedException neu, WebRequest request){
		ResponseBody responseBody = new ResponseBody();
		responseBody.setCode("FORBIDDEN_RESPONSE");
		responseBody.setMessage("You are forbidden");
		
		ResponseEntity<ResponseBody> response = new ResponseEntity<>(responseBody, HttpStatus.FORBIDDEN);
		return response;
	}
	
	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<ResponseBody> handleRuntimeException(RuntimeException run, WebRequest request){
		ResponseBody responseBody = new ResponseBody();
		responseBody.setCode("I_AM_A_TEAPOT_RESPONSE");
		responseBody.setMessage("You have hit a runtime excpetion");
		
		ResponseEntity<ResponseBody> response = new ResponseEntity<>(responseBody, HttpStatus.I_AM_A_TEAPOT);
		return response;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<ResponseBody> handleIllegalArgumentException(IllegalArgumentException iae, WebRequest request){
		ResponseBody responseBody = new ResponseBody();
		responseBody.setCode("BAD_REQUEST_RESPONSE");
		responseBody.setMessage("You have hit an IllegalArguement Exception");
		
		ResponseEntity<ResponseBody> response = new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
		return response;
	}
	
	
	public static class ResponseBody{
		private String code;
		private String message;
		
			
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
	}

}

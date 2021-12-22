package nakasone.odin.exceptionhandlerconfig;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error/id")
public class ExceptionHandlerRestController {

	@RequestMapping(method = RequestMethod.GET)
	public String throwError(@RequestParam int x) {

		String result = null;
		switch (x) {
		case 0:
			result = "Hello World";
			break;
		case 1:
			throw new IllegalArgumentException();
		case 2:
			throw new RuntimeException();
		case 3:
			throw new NeuNotAuthorizedException();
		default: 
			result = "This is not the request you're looking for.";
		}
		
		return result;

	}
}

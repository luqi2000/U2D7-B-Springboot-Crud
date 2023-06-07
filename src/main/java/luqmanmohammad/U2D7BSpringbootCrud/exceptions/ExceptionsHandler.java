package luqmanmohammad.U2D7BSpringbootCrud.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import luqmanmohammad.U2D7BSpringbootCrud.users.ErrorsPayload;

public class ExceptionsHandler {
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorsPayload> handleBadRequest(BadRequestException e) {

		ErrorsPayload payload = new ErrorsPayload(e.getMessage(), new Date(), 400);

		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorsPayload> handleNotFound(NotFoundException e) {

		ErrorsPayload payload = new ErrorsPayload(e.getMessage(), new Date(), 404);

		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorsPayload> handleGeneric(Exception e) {
		System.out.println(e);
		ErrorsPayload payload = new ErrorsPayload("Errore Generico", new Date(), 500);

		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

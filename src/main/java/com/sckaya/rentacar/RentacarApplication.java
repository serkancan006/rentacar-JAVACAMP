package com.sckaya.rentacar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sckaya.rentacar.core.utilities.exceptions.BusinessException;
import com.sckaya.rentacar.core.utilities.exceptions.ProblemDetails;
import com.sckaya.rentacar.core.utilities.exceptions.ValidationProblemDetails;

@RestControllerAdvice // (araya girme mekanizması için ekle)
@SpringBootApplication
public class RentacarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentacarApplication.class, args);
	}


	// servisimize istek atılırken eğer hata olursa bütün hataları dökme araya bir interceptor atıyoruz buna javada advice de deniliyor gibi düşüne biliriz. (araya girme)
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}

	// buda @Valid için yani request patterndaki requestların validasyonları için
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemDetails validationproblemDetails = new ValidationProblemDetails();
		validationproblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationproblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationproblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return validationproblemDetails;
	}



	// Bu bir nesne ioc ye girer bulur ve bunu ioc için ekler ismi önemli değil bunu ModelMapperService deki Ioc de talep ettiğimizde bulamadğı için eklememiz gerek ioc'ye
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}

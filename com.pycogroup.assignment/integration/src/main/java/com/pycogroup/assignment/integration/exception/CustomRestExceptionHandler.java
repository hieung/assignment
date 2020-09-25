package com.pycogroup.assignment.integration.exception;

import com.pycogroup.assignment.integration.event.RabbitMQSender;
import com.pycogroup.assignment.integration.json.EvocherJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleFailAll(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR, "Could not get Evocher from 3rd party system");
        System.out.println("----------- " + request.getParameter("simcard"));

        // Push fail back to Vocher App
        EvocherJSON evocherJSON = new EvocherJSON(null, request.getParameter("simcard"), Timestamp.valueOf(request.getParameter("createdDate")), Timestamp.from(Instant.now()), "Fail");
        rabbitMQSender.send(evocherJSON);

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}

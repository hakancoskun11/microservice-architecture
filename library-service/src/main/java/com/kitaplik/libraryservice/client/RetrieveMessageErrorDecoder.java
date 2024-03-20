package com.kitaplik.libraryservice.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitaplik.libraryservice.exception.BookNotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class RetrieveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder;

    public RetrieveMessageErrorDecoder(ErrorDecoder errorDecoder) {
        this.errorDecoder = errorDecoder;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = null;
        try (InputStream bodyIs = response.body().asInputStream()){
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ExceptionMessage.class);

        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        switch (response.status()) {
            case 404:
                throw new BookNotFoundException(message.message() != null ? message.message() : "Not Found" );
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}
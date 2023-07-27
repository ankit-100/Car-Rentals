//package com.project.rentals.onlineCarRentals.exceptionTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.project.rentals.onlineCarRentals.exception.AlreadyPresentException;
//import com.project.rentals.onlineCarRentals.exception.GlobalExceptionHandler;
//import com.project.rentals.onlineCarRentals.exception.NotFoundException;
//
//public class GlobalExceptionHandlerTest {
//
//    @Mock
//    private NotFoundException notFoundException;
//
//    @Mock
//    private AlreadyPresentException alreadyPresentException;
//
//    @InjectMocks
//    private GlobalExceptionHandler globalExceptionHandler;
//
//    @Test
//    void testNotFoundException() {
//        when(notFoundException.getMessage()).thenReturn("Not found!");
//
//        ResponseEntity<String> responseEntity = globalExceptionHandler.NotFoundException(notFoundException);
//
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Not found!", responseEntity.getBody());
//    }
//
//    @Test
//    void testNotFoundExceptionWithEmptyMessage() {
//        when(notFoundException.getMessage()).thenReturn("");
//
//        ResponseEntity<String> responseEntity = globalExceptionHandler.NotFoundException(notFoundException);
//
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Not Found! ", responseEntity.getBody());
//    }
//
//    @Test
//    void testNotFoundExceptionWithNullMessage() {
//        when(notFoundException.getMessage()).thenReturn(null);
//
//        ResponseEntity<String> responseEntity = globalExceptionHandler.NotFoundException(notFoundException);
//
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Not Found! ", responseEntity.getBody());
//    }
//
//    @Test
//    void testAlreadyPresentException() {
//        when(alreadyPresentException.getMessage()).thenReturn("Already present!");
//
//        ResponseEntity<String> responseEntity = globalExceptionHandler.AlreadyPresentException(alreadyPresentException);
//
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Already present!", responseEntity.getBody());
//    }
//
//    @Test
//    void testAlreadyPresentExceptionWithEmptyMessage() {
//        when(alreadyPresentException.getMessage()).thenReturn("");
//
//        ResponseEntity<String> responseEntity = globalExceptionHandler.AlreadyPresentException(alreadyPresentException);
//
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Already Present! ", responseEntity.getBody());
//    }
//
//    @Test
//    void testAlreadyPresentExceptionWithNullMessage() {
//        when(alreadyPresentException.getMessage()).thenReturn(null);
//
//        ResponseEntity<String> responseEntity = globalExceptionHandler.AlreadyPresentException(alreadyPresentException);
//
//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
//        assertEquals("Already Present! ", responseEntity.getBody());
//    }
//}
//

package net.futureorigin.host.web.advice;

import com.alibaba.cola.dto.Response;
import net.futureorigin.host.common.exception.AuthException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * GlobalExceptionHandler
 * <p></p>
 *
 * @author Leander Lee on 2021/8/22.
 */
@RestControllerAdvice
@Order(999)
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response expection(HttpServletRequest request, Exception e) {
        String errorCode = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
        if (e instanceof AuthException) {
            AuthException authException = (AuthException) e;
            errorCode = authException.getErrCode();
        }

        return Response.buildFailure(errorCode, e.getMessage());
    }

}

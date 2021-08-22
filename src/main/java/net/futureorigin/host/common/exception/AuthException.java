package net.futureorigin.host.common.exception;

import com.alibaba.cola.exception.BizException;

/**
 * AuthException
 * <p></p>
 *
 * @author Leander Lee on 2021/8/22.
 */
public class AuthException extends BizException {
    public AuthException(String errMessage) {
        super(errMessage);
    }

    public AuthException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public AuthException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public AuthException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }
}

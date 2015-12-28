package cn.elegs.domain.shared;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 领域模型业务异常.
 */
public class DomainException extends Exception {


    protected Log log = LogFactory.getLog(getClass());

    public DomainException(String message) {
        super(message);
    }


}

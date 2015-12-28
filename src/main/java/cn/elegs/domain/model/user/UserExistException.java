package cn.elegs.domain.model.user;

import cn.elegs.domain.shared.DomainException;

/**
 * 用户名重复异常.
 */
public class UserExistException extends DomainException {
    public UserExistException() {
        super("User exist!");
        log.error("User exist!");
    }
}

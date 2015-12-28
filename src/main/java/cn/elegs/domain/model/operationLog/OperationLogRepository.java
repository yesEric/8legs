package cn.elegs.domain.model.operationLog;

import cn.elegs.domain.shared.GenericRepository;

/**
 * 操作日志Repository.
 */
public interface OperationLogRepository extends GenericRepository<OperationLog, String> {

    /**
     * 查找用户的操作日志
     *
     * @param username 用户名
     * @return
     */
    boolean userHasLog(String username);
}

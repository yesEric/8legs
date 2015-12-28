package cn.elegs.infrastructure.persistence.hibernate;

import cn.elegs.domain.model.operationLog.OperationLog;
import cn.elegs.domain.model.operationLog.OperationLogRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作日志Repository Hibernate实现.
 */
@Repository("operationLogRepository")
public class OperationLogRepositoryHibernate extends GenericRepositoryHibernate<OperationLog, String> implements OperationLogRepository {
    public OperationLogRepositoryHibernate() {
        super(OperationLog.class);
    }

    @Override
    public boolean userHasLog(String username) {
        DetachedCriteria criteria = DetachedCriteria.forClass(OperationLog.class);
        criteria.add(Restrictions.eq("username", username));
        HibernateTemplate hibernateTemplate = new HibernateTemplate(getSessionFactory());
        try {
            List logList = hibernateTemplate.findByCriteria(criteria, 1, 1);
            if (logList != null && !logList.isEmpty()) {
                return true;
            }
        } catch (DataAccessException e) {
            return false;
        }
        return false;
    }
}

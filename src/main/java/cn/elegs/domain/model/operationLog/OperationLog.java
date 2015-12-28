package cn.elegs.domain.model.operationLog;

import cn.elegs.domain.shared.ValueObject;

import java.util.Date;

/**
 * 操作日志.
 */
public class OperationLog extends ValueObject<OperationLog> {

    String actionName;
    String username;
    Date operateDate;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    @Override
    protected boolean sameIdentityAs(OperationLog other) {
        return other != null && other.getId().equals(getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationLog that = (OperationLog) o;

        if (!actionName.equals(that.actionName)) return false;
        if (!username.equals(that.username)) return false;
        return operateDate.equals(that.operateDate);

    }

    @Override
    public int hashCode() {
        int result = actionName.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + operateDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "actionName='" + actionName + '\'' +
                ", username='" + username + '\'' +
                ", operateDate=" + operateDate +
                '}';
    }
}

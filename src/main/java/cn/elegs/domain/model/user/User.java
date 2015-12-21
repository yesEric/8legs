package cn.elegs.domain.model.user;

import cn.elegs.domain.shared.Entity;
import org.apache.commons.lang3.Validate;

import java.util.Date;

/**
 * 用户对象.
 */
public class User extends Entity<User> {

    String id;

    String username;

    String fullName;
    String password;

    /**
     * 用户状态:0-正常,1-无效
     */
    UserStatus status;
    /**
     * 用户锁定状态:1-锁定;0-未锁定
     *
     */
    LockStatus locked;

    Date createdAt;



    public User() {
    }

    public User(String username, String password) {
        Validate.notBlank(username,"Username can not be null!");
        Validate.notNull(password,"Password can not be null!");
        this.username = username;
        this.password = password;
        this.createdAt=new Date();
        this.status=UserStatus.ACTIVATED;
        this.locked=LockStatus.UNLOCKED;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public LockStatus getLocked() {
        return locked;
    }

    public void setLocked(LockStatus locked) {
        this.locked = locked;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    private void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 激活用户
     */
    public void active(){
        this.status=UserStatus.ACTIVATED;
    }

    /**
     * 冻结用户
     */
    public void inactive(){
        this.status=UserStatus.INACTIVATED;
    }

    /**
     * 锁定用户
     */
    public void lock(){
        this.locked=LockStatus.LOCKED;
    }

    /**
     * 解锁用户
     */

    public void unlock(){
        this.locked=LockStatus.UNLOCKED;
    }

    public void changePwd(String password){
        Validate.notBlank(password,"Password can not be null!");
        this.password=password;
    }
    @Override
    public boolean sameIdentityAs(User other) {
        return other!=null && username.equals(other.username);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username.equals(user.username);

    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", locked=" + locked +
                ", createdAt=" + createdAt +
                '}';
    }
}

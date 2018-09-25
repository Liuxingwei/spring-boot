package cn.liuxingwei.spring.boot.orm.domain;

import org.springframework.stereotype.Component;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.sql.Date;

@Component
public class UserDao {

    private Long userId;

    private String userName;

    private String password;

    private Short userType;

    private Short locked;

    private Long credit;

    private Date lastVisit;

    private String lastIp;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Short getUserType() {
        return userType;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

    public Short getLocked() {
        return locked;
    }
    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getCredit() {
        return credit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getLastIp() {
        return lastIp;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

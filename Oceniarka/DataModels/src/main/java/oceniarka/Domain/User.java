package oceniarka.Domain;

import oceniarka.framework.DateTruncator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by eryk on 27.10.15.
 */
public class User {

    private String username;

    private String password;

    private Boolean enabled = true;

    private Boolean deleted = false;

    private Date createTime;

    private Date lastSeenTime;

    public User(String username, String password, Boolean enabled, Boolean deleted, Date createTime,
            Date lastSeenTime) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.deleted = deleted;
        this.createTime = createTime;
        this.lastSeenTime = lastSeenTime;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", lastSeenTime=" + lastSeenTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder()
                .append(getUsername(), user.getUsername())
                .append(getPassword(), user.getPassword())
                .append(getEnabled(), user.getEnabled())
                .append(deleted, user.deleted)
                .append(DateTruncator.trancuateMilliseconds(getCreateTime()),
                        DateTruncator.trancuateMilliseconds(user.getCreateTime()))
                .append(DateTruncator.trancuateMilliseconds(getLastSeenTime()),
                        DateTruncator.trancuateMilliseconds(user.getLastSeenTime()))
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getUsername())
                .append(getPassword())
                .append(getEnabled())
                .append(deleted)
                .append(getCreateTime())
                .append(getLastSeenTime())
                .toHashCode();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastSeenTime() {
        return lastSeenTime;
    }

    public void setLastSeenTime(Date lastSeenTime) {
        this.lastSeenTime = lastSeenTime;
    }
}

package app.mysqltest.domain;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

import java.time.LocalDate;

/**
 * @author steve
 */
@Table(name = "user_infos")
public class UserInfo {

    @PrimaryKey(autoIncrement = true)
    @NotNull
    @Column(name = "user_id")
    public Integer userId;

    @NotBlank
    @Column(name = "user_name")
    public String userName;

    @NotBlank
    @Column(name = "user_pwd")
    public String userPwd;

    @Column(name = "user_birthday")
    public LocalDate userBirthday;

    @NotBlank
    @Column(name = "user_phone")
    public String userPhone;

    @Column(name = "user_img")
    public String userImg;

    @Override
    public String toString() {
        return "UserInfo{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userPwd='" + userPwd + '\'' +
            ", userBirthday=" + userBirthday +
            ", userPhone='" + userPhone + '\'' +
            ", userImg='" + userImg + '\'' +
            '}';
    }
}

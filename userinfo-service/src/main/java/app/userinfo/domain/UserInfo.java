package app.userinfo.domain;

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
    @Column(name = "id")
    public Integer id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    public String name;

    @NotNull
    @NotBlank
    @Column(name = "password")
    public String password;

    @Column(name = "birthday")
    public LocalDate birthday;

    @NotNull
    @NotBlank
    @Column(name = "phone")
    public String phone;

    @Column(name = "img")
    public String img;
}

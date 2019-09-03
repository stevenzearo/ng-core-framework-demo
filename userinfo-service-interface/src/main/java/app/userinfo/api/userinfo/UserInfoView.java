package app.userinfo.api.userinfo;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

import java.time.LocalDate;

/**
 * @author steve
 */
public class UserInfoView {

    @Property(name = "id")
    public Integer id;

    @Property(name = "name")
    public String name;

    @Property(name = "password")
    public String password;

    @Property(name = "birthday")
    public LocalDate birthday;

    @Property(name = "phone")
    public String phone;

    @Property(name = "img")
    public String img;
}

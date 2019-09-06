package app.userinfo.api.userinfo;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

import java.time.LocalDate;

/**
 * @author steve
 */
public class CreateUserInfoRequest {
    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;

    @NotNull
    @NotBlank
    @Property(name = "password")
    public String password;

    @Property(name = "birthday")
    public LocalDate birthday;

    @NotNull
    @NotBlank
    @Property(name = "phone")
    public String phone;

    @Property(name = "img")
    public String img;
}

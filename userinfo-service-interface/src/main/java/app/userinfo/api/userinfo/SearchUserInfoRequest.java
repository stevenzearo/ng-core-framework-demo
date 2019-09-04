package app.userinfo.api.userinfo;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

import java.time.LocalDate;

/**
 * @author steve
 */
public class SearchUserInfoRequest {
    @NotNull
    @Property(name = "skip")
    public Integer skip = 0;

    @NotNull
    @Property(name = "limit")
    public Integer limit = 10;

    @Property(name = "name")
    public String name;

    @Deprecated
    @Property(name = "password")
    public String password;
    @Deprecated
    @Property(name = "birthday")
    public LocalDate birthday;
    @Deprecated
    @Property(name = "phone")
    public String phone;
}

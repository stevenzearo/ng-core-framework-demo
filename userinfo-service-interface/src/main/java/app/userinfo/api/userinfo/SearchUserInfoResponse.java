package app.userinfo.api.userinfo;

import core.framework.api.json.Property;

import java.util.List;

/**
 * @author steve
 */
public class SearchUserInfoResponse {
    @Property(name = "total")
    public Integer total;

    @Property(name = "user_info_list")
    public List<UserInfoView> userInfoViewList;
}

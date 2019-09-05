package app.mysqltest.domain;

import core.framework.db.DBEnumValue;

/**
 * @author steve
 */
public enum MovieStatus {
    @DBEnumValue("ONLINE")
    ONLINE,
    @DBEnumValue("OFFLINE")
    OFFLINE
}

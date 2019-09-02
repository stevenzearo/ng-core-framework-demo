package app.mysqltest.domain;

import core.framework.db.DBEnumValue;

/**
 * @author steve
 */
public enum MovieStatus {
    @DBEnumValue(value = "online")
    ONLINE,
    @DBEnumValue(value = "offline")
    OFFLINE
}

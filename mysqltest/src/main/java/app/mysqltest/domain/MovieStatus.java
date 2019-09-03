package app.mysqltest.domain;

import core.framework.db.DBEnumValue;

/**
 * @author steve
 */
public enum MovieStatus {
    @DBEnumValue(value = "ONLINE")
    ONLINE,
    @DBEnumValue(value = "OFFLINE")
    OFFLINE
}

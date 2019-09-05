package app.domain;

import core.framework.mongo.Collection;
import core.framework.mongo.Field;
import core.framework.mongo.Id;

/**
 * @author steve
 */
@Collection(name = "address")
public class Address {
    @Id
    @Field(name = "id")
    public String id;

    @Field(name = "province")
    public Province province;
}

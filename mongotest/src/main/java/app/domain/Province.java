package app.domain;

import core.framework.mongo.Collection;
import core.framework.mongo.Field;
import core.framework.mongo.Id;

/**
 * @author steve
 */
@Collection(name = "province")
public class Province {
    @Id
    @Field(name = "id")
    public String id;

    @Field(name = "name")
    public String name;
}

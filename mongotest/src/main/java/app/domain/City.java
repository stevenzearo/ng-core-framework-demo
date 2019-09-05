package app.domain;

import core.framework.mongo.Collection;
import core.framework.mongo.Field;

/**
 * @author steve
 */
@Collection(name = "city")
public class City {
    @Field(name = "id")
    public String id;

    @Field(name = "name")
    public String name;

    @Field(name = "zone")
    public Zone zone;
}

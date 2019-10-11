package app.domain;

import core.framework.mongo.Collection;
import core.framework.mongo.Field;

/**
 * @author steve
 */
public class Province {
    @Field(name = "id")
    public String id;

    @Field(name = "name")
    public String name;

    @Field(name = "city")
    public City city;
}

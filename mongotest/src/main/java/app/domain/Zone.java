package app.domain;

import core.framework.mongo.Collection;
import core.framework.mongo.Field;
import org.bson.types.ObjectId;

/**
 * @author steve
 */
@Collection(name = "zone")
public class Zone {
    @Field(name = "id")
    public ObjectId id;

    @Field(name = "name")
    public String name;
}

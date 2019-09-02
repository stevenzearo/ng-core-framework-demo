package app.mysqltest.domain;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.db.Column;
import core.framework.db.DBEnumValue;
import core.framework.db.PrimaryKey;
import core.framework.db.Table;

import java.time.ZonedDateTime;

/**
 * @author steve
 */
@Table(name = "movie_orders")
public class MovieOrder {
    @PrimaryKey
    @NotBlank
    @Column(name = "movie_order_id")
    public String movieOrderId;

    @NotNull
    @Column(name = "user_id")
    public Integer userId;

    @NotNull
    @Column(name = "amount")
    public Float amount;

    @NotNull
    @Column(name = "order_time")
    public ZonedDateTime orderTime;

    @NotNull
    @Column(name = "status")
    public OrderStatus orderStatus;
}

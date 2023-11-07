package jz.cbq.work03.cbq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Order
 *
 * @author CBQ
 * @date 2023/11/8 0:46
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * id
     */
    private Integer id;
    /**
     * 订单列表
     */
    private List<OrderItem> orderItems;
    /**
     * 总价格
     */
    private Double total;
}

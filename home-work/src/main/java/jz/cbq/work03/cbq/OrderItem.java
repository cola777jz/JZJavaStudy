package jz.cbq.work03.cbq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrderItem
 *
 * @author CBQ
 * @date 2023/11/8 0:46
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    /**
     * id
     */
    private Integer id;
    /**
     * 书籍
     */
    private Book book;
    /**
     * 数量
     */
    private Integer count;
}

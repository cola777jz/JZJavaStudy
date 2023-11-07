package jz.cbq.work03.cbq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book
 *
 * @author CBQ
 * @date 2023/11/8 0:45
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private Double price;
    /**
     * 库存
     */
    private Integer storage;
}

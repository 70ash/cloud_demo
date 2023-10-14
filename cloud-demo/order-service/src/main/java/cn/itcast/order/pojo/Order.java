package cn.itcast.order.pojo;

import cn.itcast.feign.pojo.User;
import lombok.Data;

/**
 * @author zlp
 * @date 2023/9/9 12:27
 */
@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}

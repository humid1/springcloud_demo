package com.humid.springcloud.domain;

import lombok.Data;

/**
 * @author qiujianping
 * @date Created in 2021/6/24 16:01
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}

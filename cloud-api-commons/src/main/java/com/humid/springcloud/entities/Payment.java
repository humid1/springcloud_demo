package com.humid.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiujianping
 * @date Created in 2021/4/28 14:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;

    private String createTime;

    private String updateTime;

    private String serial;

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }
}

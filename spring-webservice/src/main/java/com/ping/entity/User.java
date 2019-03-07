package com.ping.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zhangsp
 * @date: 2019/3/6 20:13
 * @copyright: @2019
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5864608429431944267L;

    private Long userId;

    private String userName;

    private String email;

    private Date gmtCreate;
}

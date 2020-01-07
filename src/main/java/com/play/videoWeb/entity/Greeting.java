package com.play.videoWeb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务器回复消息实体
 * @author liujc
 * @ate 2020-01-07 15:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {

    private String content;
}

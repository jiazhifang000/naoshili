package com.naoshili.information.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 采集数据基本信息
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
@Data
public class ChartDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String x;

    private Object y;
}

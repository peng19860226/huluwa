package com.uap.ez.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 日记账表
 * </p>
 *
 * @author xp
 * @since 2019-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EzAccountbook implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 项目
     */
    private String projectid;

    /**
     * 发票类型
     */
    private String invoicetype;

    /**
     * 开始日期
     */
    private String startdate;

    /**
     * 结束日期
     */
    private String enddate;

    /**
     * 出发地
     */
    private String departurecity;

    /**
     * 目的地
     */
    private String destinationcity;

    /**
     * 备注
     */
    private String note;

    /**
     * 酒店名称
     */
    private String hotelname;

    /**
     * 餐饮公司
     */
    private String cateringcorp;

    /**
     * 就餐人数
     */
    private Integer personnum;

    /**
     * 费用类型
     */
    private Integer ostctype;

    /**
     * 收支项目
     */
    private String paymentsproject;

    /**
     * 通讯类型
     */
    private BigDecimal communicationtype;

    /**
     * 版本控制
     */
    @Version
    private Integer version;

    /**
     * 删除标记
     */
    @TableLogic
    private Integer dr;


}

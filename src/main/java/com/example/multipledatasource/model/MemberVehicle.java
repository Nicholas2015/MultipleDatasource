package com.example.multipledatasource.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class MemberVehicle {


    /**
     * 记录唯一标识
     */
    private String recordId;

    /**
     * 停车场id
     */
    private Long parkinglotId;

    /**
     * 车牌号码
     */
    private String plateNumber;

    /**
     * 车牌颜色
     */
    private Integer plateColor;

    /**
     * 车辆类型
     */
    private String vehicleType;

    /**
     * 车主id
     */
    private String userId;

    /**
     * 收费规则id
     */
    private Long feeRuleId;

    /**
     * 车主姓名
     */
    private String vehicleOwner;

    /**
     * 车主电话
     */
    private String vehicleOwnerPhone;

    /**
     * 会员类型
     */
    private Integer memberType;


    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 付款金额
     */
    private Double fee;

    /**
     * 会员交易订单编号
     */
    private String outTradeNo;

    /**
     * 备注信息
     */
    private String ext;

    /**
     * 相关证明文件url
     */
    private String certifiedDocUrl;

    /**
     *
     */
    private String invoiceNo;
}

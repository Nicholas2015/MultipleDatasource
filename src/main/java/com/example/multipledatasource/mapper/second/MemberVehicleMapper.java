package com.example.multipledatasource.mapper.second;

import com.example.multipledatasource.model.MemberVehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberVehicleMapper {

    @Select({"SELECT record_id AS recordId,parkinglot_id AS parkinglotId,plate_number AS palteNumer,plate_color AS plateColor,vehicle_type AS vehicleType,user_id AS userId,fee_rule_id AS feeRuleId,vehicle_owner AS vehicleOwner,vehicle_owner_phone AS vehicleOwnerPhone,member_type AS memberType,start_time AS startTime,end_time AS endTime,fee,out_trade_no AS outTradeNo,ext,create_by AS createBy,create_time AS createTime,del_flag AS delFlag FROM t_member_vehicle"})
    List<MemberVehicle> selectMemberVehicleList();
}

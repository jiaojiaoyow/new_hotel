package com.example.hotel.service;

import com.example.hotel.model.Essay;
import com.example.hotel.model.RoomOrder;
import com.example.hotel.model.RoomOrderExample;
import com.example.hotel.model.RoomOrderKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface RoomOrderService {

    long countByExample(RoomOrderExample example);

    int deleteByExample(RoomOrderExample example);

    int deleteByPrimaryKey(RoomOrderKey key);

    int insert(RoomOrder record);

    int insertSelective(RoomOrder record);

    List<RoomOrder> selectByExampleWithRowbounds(RoomOrderExample example, RowBounds rowBounds);

    List<RoomOrder> selectByExample(RoomOrderExample example);

    RoomOrder selectByPrimaryKey(RoomOrderKey key);

    int updateByExampleSelective(@Param("record") RoomOrder record, @Param("example") RoomOrderExample example);

    int updateByExample(@Param("record") RoomOrder record, @Param("example") RoomOrderExample example);

    int updateByPrimaryKeySelective(RoomOrder record);

    int updateByPrimaryKey(RoomOrder record);

    //自己添加的

    List <RoomOrder> selectByUserid(String uid);

    String selectByRDU(RoomOrder record);

    RoomOrder selectByOrderid(String  orderid);


    List<RoomOrder> selectAllCompleteOrder(Map map);

    List<RoomOrder> selectPage(Map map);


    List<RoomOrder> selectAllOrder(Map map);

    List<RoomOrder> selectAllPayOrder();

    int selectCount();


}

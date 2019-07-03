package com.example.hotel.service.Impl;

import com.example.hotel.dao.RoomOrderMapper;
import com.example.hotel.model.RoomOrder;
import com.example.hotel.model.RoomOrderExample;
import com.example.hotel.model.RoomOrderKey;
import com.example.hotel.service.RoomOrderService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("RoomOrderService")
public class RoomOrderServiceImpl implements RoomOrderService {

    @Autowired
    private RoomOrderMapper roomOrderMapper;

    @Override
    public long countByExample(RoomOrderExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(RoomOrderExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(RoomOrderKey key) {
        return 0;
    }

    @Override
    public int insert(RoomOrder record) {
        return 0;
    }

    @Override
    public int insertSelective(RoomOrder record) {
        return roomOrderMapper.insertSelective(record);
    }

    @Override
    public List<RoomOrder> selectByExampleWithRowbounds(RoomOrderExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<RoomOrder> selectByExample(RoomOrderExample example) {
        return null;
    }

    @Override
    public RoomOrder selectByPrimaryKey(RoomOrderKey key) {
        return roomOrderMapper.selectByPrimaryKey(key);
    }

    @Override
    public int updateByExampleSelective(RoomOrder record, RoomOrderExample example) {
        return 0;
    }

    @Override
    public int updateByExample(RoomOrder record, RoomOrderExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(RoomOrder record) {
        return roomOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoomOrder record) {
        return 0;
    }

    @Override
    public List<RoomOrder> selectByUserid(String uid) {
        return roomOrderMapper.selectByUserid(uid);
    }

    @Override
    public String selectByRDU(RoomOrder record) {
        return roomOrderMapper.selectByRDU(record);
    }

    @Override
    public RoomOrder selectByOrderid(String orderid) {
        return roomOrderMapper.selectByOrderid(orderid);
    }

    @Override
    public List<RoomOrder> selectAllCompleteOrder(Map map) {
        return roomOrderMapper.selectAllCompleteOrder(map);
    }

    @Override
    public List<RoomOrder> selectPage(Map map) {
        return roomOrderMapper.selectPage(map);
    }


    @Override
    public List<RoomOrder> selectAllOrder(Map map) {
        return roomOrderMapper.selectAllOrder(map);
    }

    @Override
    public List<RoomOrder> selectAllPayOrder() {
        return roomOrderMapper.selectAllPayOrder();
    }

    @Override
    public int selectCount() {
        return roomOrderMapper.selectCount();
    }


}

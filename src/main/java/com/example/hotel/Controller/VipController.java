package com.example.hotel.Controller;

import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.DTO.VipDTO;
import com.example.hotel.model.User;
import com.example.hotel.model.VipCard;
import com.example.hotel.service.UserService;
import com.example.hotel.service.VipService;
import com.example.hotel.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class VipController {

    @Autowired
    private UserService userService;

    @Autowired
    private VipService vipService;

    @RequestMapping("/api/getVip")
    public ResultDTO getVip(VipDTO vipDTO){
        ResultDTO resultDTO=new ResultDTO();
        try {
            if(vipDTO.getPhone()==null){
                return resultDTO.nothing();
            }
            //新增Vip
            VipCard vipCard=new VipCard();
            Date date= new Date();
            vipCard.setVid(DateUtil.change_str(date));
            vipCard.setGender(vipDTO.getGender());
            vipCard.setPhone(vipDTO.getPhone());
            vipCard.setUsername(vipDTO.getUsername());

            int flag=vipService.insertSelective(vipCard);
            if(flag==0){
                return resultDTO.fail("无法获得会员卡");
            }
            //更改用户表
            User user=userService.selectByPrimaryKey(vipDTO.getUid());
            user.setStatus(1);
            user.setVip(DateUtil.change_str(date));
            userService.saveOrUpdate(user);
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

    @RequestMapping("/api/isVip")
    public ResultDTO isVip(String uid){
        ResultDTO resultDTO=new ResultDTO();
        try {
            if(uid==null){
                return resultDTO.nothing();
            }
            User user =userService.selectByPrimaryKey(uid);
            if(user.getUid()==null){
                return resultDTO.fail();
            }
            if(user.getStatus()==1){
                return resultDTO.ok("是Vip");

            }
            return resultDTO.ok("非Vip");
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

    @RequestMapping("/api/getVipMessage")
    public ResultDTO getVipMessage(String uid){
        ResultDTO resultDTO=new ResultDTO();
        try {
            if(uid==null){
                return resultDTO.nothing();
            }
            User user =userService.selectByPrimaryKey(uid);
            if(user.getUid()==null){
                return resultDTO.fail();
            }
            if(user.getStatus()==1){
                VipCard vipCard=vipService.selectByPrimaryKey(user.getVip());
                return resultDTO.ok(vipCard);
            }
            return resultDTO.ok("非Vip");
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }
}

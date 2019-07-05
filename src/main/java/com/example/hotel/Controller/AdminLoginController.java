package com.example.hotel.Controller;

import com.example.hotel.DTO.AdminDTO;
import com.example.hotel.DTO.ResultDTO;
import com.example.hotel.model.Admin;
import com.example.hotel.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/api/back/login")
    public ResultDTO login(@RequestBody AdminDTO admin){
        ResultDTO resultDTO=new ResultDTO();
        try {
//            Admin admin2=new Admin();
//            BeanUtils.copyProperties(admin2,admin);
            if(admin.getUname()==null){
                return resultDTO.nothing();
            }
            Admin admin1=adminService.selectByUname(admin.getUname());
            if(!admin1.getPassword().equals(admin.getPassword())){
                return resultDTO.fail("密码错误");
            }
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

    @RequestMapping("/api/back/selAdmin")
    public ResultDTO selAdmin(){
        ResultDTO resultDTO=new ResultDTO();
        try {

            List<Admin> admin1=adminService.selectAll();
            if(admin1.size()==0){
                return resultDTO.fail();
            }
            return resultDTO.ok(admin1);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }


    @RequestMapping("/api/back/alterOrSaveAdmin")
    public ResultDTO alter(@RequestBody AdminDTO admin){
        ResultDTO resultDTO=new ResultDTO();
        try {
            if(admin.getUname()==null){
                return resultDTO.nothing();
            }
            Admin admin1=new Admin();
            BeanUtils.copyProperties(admin,admin1);
            int flag=adminService.saveOrUpdate(admin1);
            if(flag==0){
                return resultDTO.fail("新建或更改管理员失败");
            }
            return resultDTO.ok(null);
        }catch (org.springframework.dao.DuplicateKeyException e){
            return resultDTO.interFail("Admin");
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }

    @RequestMapping("/api/back/deleteAdmin")
    public ResultDTO delete(Integer adminId){
        ResultDTO resultDTO=new ResultDTO();
        try {
            if(adminId==null){
                return resultDTO.nothing();
            }
            int flag=adminService.deleteByPrimaryKey(adminId);
            if(flag==0){
                return resultDTO.fail("管理员删除失败");
            }
            return resultDTO.ok(null);
        }catch (Exception e){
            return resultDTO.unkonwFail(e.toString());
        }
    }
}

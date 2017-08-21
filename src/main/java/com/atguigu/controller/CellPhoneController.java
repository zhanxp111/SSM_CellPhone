package com.atguigu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.TableView.TableCell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.Cellphone;
import com.atguigu.service.CellphoneService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Controller
public class CellPhoneController {

    @Autowired
    CellphoneService cellPhoneService;

    /**
     * 查询所有手机
     * 
     * @return
     */
    @RequestMapping("/phones")
    public String getPhones(@RequestParam(value="pn",defaultValue="1")Integer pn,
            @RequestParam(value="ps",defaultValue="5")Integer ps, Model model) {
        PageHelper.startPage(pn, ps);
        List<Cellphone> all = cellPhoneService.getAll();
        PageInfo<Cellphone> info = new PageInfo<>(all,6);
        model.addAttribute("phones", info);
        return "list";
    }
    
    /**
     * 添加
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param session
     * @param phoneName
     * @param phonePrice
     * @param phoneColor
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/add", produces="text/html;charset=utf-8")
    public String addPhone(Cellphone cellphone) {
        System.out.println(cellphone);
        try {
            // 保存到数据库中
            boolean flag = cellPhoneService.addPhone(cellphone);
            if (flag) {
                return "添加成功";
            } else {
                return "添加失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "添加错误";
        }

    }
    
    /**
     * 删除
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param id
     * @return
     */
    @RequestMapping(value="/del")
    public String deletePhone(@RequestParam(value="phoneId",defaultValue="")Integer phoneId){
        if(phoneId != null){
            cellPhoneService.delete(phoneId);
        }
        
        return "redirect:/phones";
    }
  
    /**
     * 修改
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit")
    public String updatePhone(@ModelAttribute("Cellphone")Cellphone phone) {
        cellPhoneService.save(phone);
        
        //修改完成重新查询
        return "修改成功";
    }
    
    //根据id查询手机
    @ModelAttribute
    public void myModelAttribute(
            @RequestParam(value = "phoneId", required = false) Integer id,Model model) {
        if (id != null) {
            Cellphone phone = cellPhoneService.get(id);
            model.addAttribute("phone", phone);
        }
    }

}

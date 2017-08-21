package com.atguigu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Cellphone;
import com.atguigu.dao.CellphoneMapper;
import com.atguigu.service.CellphoneService;

@Service
public class CellphoneServiceImpl implements CellphoneService{
    @Autowired
    CellphoneMapper cellphoneMapper;

    public List<Cellphone> getAll() {
        return cellphoneMapper.selectByExample(null);
    }


    public void delete(Integer phoneId) {
        cellphoneMapper.deleteByPrimaryKey(phoneId);
    }

    public Cellphone get(Integer id) {
        Cellphone cellphone = cellphoneMapper.selectByPrimaryKey(id);
        return cellphone;
    }

    @Override
    public boolean addPhone(Cellphone phone) {
        return  cellphoneMapper.insert(phone) > 0;
    }


    @Override
    public void save(Cellphone phone) {
        cellphoneMapper.updateByPrimaryKey(phone);
    }


   /* @Override
    public Cellphone getPhoneById(Integer phoneId) {
        Cellphone cellphone = cellphoneMapper.selectByPrimaryKey(phoneId);
        return cellphone;
    }*/




}

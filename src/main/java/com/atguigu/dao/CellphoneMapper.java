package com.atguigu.dao;

import com.atguigu.bean.Cellphone;
import com.atguigu.bean.CellphoneExample;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CellphoneMapper {
    int countByExample(CellphoneExample example);

    int deleteByExample(CellphoneExample example);

    int deleteByPrimaryKey(Integer phoneId);

    int insert(Cellphone record);

    int insertSelective(Cellphone record);

    List<Cellphone> selectByExample(CellphoneExample example);

    Cellphone selectByPrimaryKey(Integer phoneId);

    int updateByExampleSelective(@Param("record") Cellphone record, @Param("example") CellphoneExample example);

    int updateByExample(@Param("record") Cellphone record, @Param("example") CellphoneExample example);

    int updateByPrimaryKeySelective(Cellphone record);

    int updateByPrimaryKey(Cellphone record);

    Collection<Cellphone> getAll();

    void delete(Integer phoneId);

    void get(Integer phoneId);
}
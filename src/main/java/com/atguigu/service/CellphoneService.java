package com.atguigu.service;

import java.util.List;




import com.atguigu.bean.Cellphone;


public interface CellphoneService {
    
    public List<Cellphone> getAll() ;


    public Cellphone get(Integer phoneId);

    public boolean addPhone(Cellphone phone);

    public void save(Cellphone phone);


    public void delete(Integer phoneId);

    /*public Cellphone getPhoneById(Integer phoneId);*/




    

   
    
    
    
}

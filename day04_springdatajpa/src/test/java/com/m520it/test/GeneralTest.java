package com.m520it.test;

import com.m520it.dao.CustomerDao;
import com.m520it.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GeneralTest {


    @Autowired
    private CustomerDao dao;

    /**
     * 测试保存和更新的操作
     *     *设置id的值:更新的操作
     *     *不设置id的值:保存的操作
     */
    @Test
    public void testSave(){
        Customer customer=new Customer();
        customer.setCustName("小萱萱");
        customer.setCustIndustry("IT行业");
        customer.setCustAddress("南京");
        customer.setCustLevel("中级程序员");
        customer.setCustSource("科班出身");
        customer.setCustPhone("025-1283845");
        customer.setCustId(3);
        Customer c1 = dao.save(customer);
        System.out.println(c1);
    }

    /**
     * 测试删除的操作
     */
    @Test
    public void testDelete(){
        dao.deleteById(3);
    }

    /**
     * 测试查询的操作
     *    *单个查询  :findById的方法,立即加载
     */
    @Test
    public void testFindOne(){
        Optional<Customer> optional = dao.findById(2);
        System.out.println(optional.get());
    }
    /**
     * 测试查询的操作
     *    *单个查询  :getOne的方法,懒加载
     *    *需要额外加上事物的控制@Transactional
     */
    @Test
    @Transactional
    public void testGetOne(){
        Customer customer = dao.getOne(2);
        System.out.println(customer);
    }

    /**
     * 测试查询所有的客户的信息
     */
    @Test
    public void testFindAll(){
        List<Customer> list = dao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}

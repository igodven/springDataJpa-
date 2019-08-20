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

/**
 * 自定义条件的测试
 *     *用jpql的语句进行增删改查的基本的操作
 *     *用sql的语句进行基本的增删改查的操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomConditionTest {

    @Autowired
    private CustomerDao dao;

    /**
     * 根据指定的客户的名称进行客户的单条数据的查询
     */
    @Test
    public void testFindByName(){
        Customer customer = dao.findByCustomerName("郝晨萱");
        System.out.println(customer);
    }

    /**
     * 根据指定的客户的名字进行模糊查询
     */
    @Test
    public void testFindByNameLike(){
        List<Customer> list = dao.findByNameLike("小%");
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 根据指定的id对数据库的数据进行更改
     *      *自定义的jpql的语句需要事物的支持
     */
    @Test
    @Transactional
    public void testUpdateCustomer(){
        dao.updateCustomer("小萱", 4);
    }

    /**
     * 删除的操作
     */
    @Test
    public void testDeleteCustomerById(){
        dao.deleteCustomerById(4);
    }


    /**
     * 用sql语句的方式对数据库进行增删改查
     */

    //查询所有的客户
    @Test
    public void testFindAll(){
        List<Customer> list = dao.findAllCustomer();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    //对客户进行更改
    @Test
    public void testUpdateCustomerBySQL(){
        dao.updateCustomerBySQL("郝晨萱",5);
    }

}

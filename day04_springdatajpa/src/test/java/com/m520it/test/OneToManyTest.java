package com.m520it.test;

import com.m520it.dao.CustomerDao;
import com.m520it.dao.LinkManDao;
import com.m520it.domain.Customer;
import com.m520it.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    public void testSave(){
        Customer customer=new Customer();
        customer.setCustName("小华");
        customer.setCustIndustry("机械制造");
        customer.setCustAddress("南京");
        customer.setCustLevel("高级机械师");
        customer.setCustSource("自学");
        customer.setCustPhone("0356-254866");

        LinkMan linkMan=new LinkMan();
        linkMan.setLkmName("王五");
        linkMan.setLkmPosition("销售员");
        linkMan.setLkmPhone("12568525435");
        linkMan.setLkmMobile("0235-56866");
        linkMan.setLkmMemo("小五");
        linkMan.setLkmGender("男");
        linkMan.setLkmEmail("wangwu@163.com");
        //奖励外键的联系
        linkMan.setCustomer(customer);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    public void testDelete(){
        customerDao.deleteById(1);
    }

    @Test
    @Transactional
    public void testFindOne(){
        Optional<Customer> optional = customerDao.findById(2);
        System.out.println(optional.get());
        Set<LinkMan> linkMans = optional.get().getLinkMans();
        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }
    }
}

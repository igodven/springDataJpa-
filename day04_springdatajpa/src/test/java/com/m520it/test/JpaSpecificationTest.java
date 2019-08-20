package com.m520it.test;


import com.m520it.dao.CustomerDao;
import com.m520it.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpaSpecificationTest {

    @Autowired
    private CustomerDao dao;

    /**
     * 总结:除了equal的方法,进行精准匹配
     *    其他的方法都需要加上path.as(所匹配类型的字节码)
     *        *criteriaBuilder.like(custName.as(String.class), "郝%")
     */
    /**
     * 根据指定的名字查询出所有的有关的客户
     */
    @Test
    public void  testFindAll(){
        List<Customer> list = dao.findAll(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Predicate predicate = criteriaBuilder.equal(custName, "郝晨萱");
                return predicate;
            }
        });
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 模糊查询
     *     根据指定的条件进行模糊查询
     */
    @Test
    public void testFindlike(){
        List<Customer> list = dao.findAll(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Predicate predicate = criteriaBuilder.like(custName.as(String.class), "郝%");
                return predicate;
            }
        });
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 进行分页的查询
     */
    @Test
    public void testPage(){
        Page<Customer> page = dao.findAll(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        }, PageRequest.of(0, 2));
        for (Customer customer : page) {
            System.out.println(customer);
        }
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }

    /**
     * 按照custId进行排序
     */
    @Test
    public void testSort(){
        List<Customer> list = dao.findAll(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        }, new Sort(Sort.Direction.DESC, "custId"));
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}

package com.m520it.dao;

import com.m520it.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {

    @Query("from Customer where custName=:name")  //表示查询
    Customer findByCustomerName(@Param("name") String custName);

    @Query("from Customer where custName like :name")
    List<Customer> findByNameLike(@Param("name") String s);

    @Query("update Customer  set custName=:name where custId=:id")
    @Modifying         //表示更改的操作
    void updateCustomer(@Param("name") String custName, @Param("id") int custId);

    @Query("delete from Customer where custId=:id")
    @Modifying
    @Transactional
    void deleteCustomerById(@Param("id") int custId);

    @Query(value = "select * from cst_customer",nativeQuery = true)
    List<Customer> findAllCustomer();

    @Query(value = "update cst_customer set cust_name=:name where cust_id=:id",nativeQuery = true)
    @Modifying
    @Transactional
    void updateCustomerBySQL(@Param("name") String name, @Param("id") int id);
}

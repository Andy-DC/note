package com.demo.mapper;

import com.demo.entity.TestDo;
import com.demo.entity.TestDoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestDo record);

    int insertSelective(TestDo record);

    List<TestDo> selectByExample(TestDoExample example);

    TestDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestDo record);

    int updateByPrimaryKey(TestDo record);


    List<TestDo> selectTestByName(@Param("name") String name);
}
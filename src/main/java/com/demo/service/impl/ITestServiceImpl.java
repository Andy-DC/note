package com.demo.service.impl;

import com.demo.common.constant.vo.PageVO;
import com.demo.common.util.ErrorAndVOTuple;
import com.demo.common.util.ErrorCodeEnum;
import com.demo.common.util.ErrorProperties;
import com.demo.entity.TestDo;
import com.demo.mapper.TestDoMapper;
import com.demo.model.param.TestNameParams;
import com.demo.model.vo.IVo;
import com.demo.model.vo.TestListPageVo;
import com.demo.service.ITestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ITestServiceImpl implements ITestService {
    @Autowired
    private TestDoMapper testDoMapper;
    @Autowired
    private ErrorProperties errorProperties;


    @Override
    public ErrorAndVOTuple<IVo> addTest(TestDo testDo) {
        int i = testDoMapper.insertSelective(testDo);
        if (i != 1) {
            return new ErrorAndVOTuple(ErrorCodeEnum.SYSTEM_ERROR.getCode(),errorProperties.getErrorMsg(100006),i);
        }
        return new ErrorAndVOTuple(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMsg(), i);
    }

    @Override
    public ErrorAndVOTuple<TestListPageVo> listTest(TestNameParams params) {
        TestListPageVo vo = new TestListPageVo();
        Integer pageNumber = Integer.parseInt(params.getPageNumber());
        Integer pageSize = Integer.parseInt(params.getPageSize());
        if (null != pageNumber && pageSize > 0) {
            PageHelper.startPage(pageNumber, pageSize);
        }
         List<TestDo> infolist = testDoMapper.selectTestByName(params.getName());
        log.info("infoList:{}", infolist);
        PageInfo<TestDo> pageInfo = new PageInfo<>(infolist);
        List<TestDo> list = pageInfo.getList();
        log.info("List:{}", list);
        PageVO pageVO = new PageVO(pageInfo);
        vo.setList(list);

        vo.setPage(pageVO);


        return new ErrorAndVOTuple<>(ErrorCodeEnum.SUCCESS.getCode(),ErrorCodeEnum.SUCCESS.getMsg(), vo);
    }
}

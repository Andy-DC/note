package com.demo.service;

import com.demo.common.util.ErrorAndVOTuple;
import com.demo.entity.TestDo;
import com.demo.model.param.TestNameParams;
import com.demo.model.vo.IVo;
import com.demo.model.vo.TestListPageVo;

public interface ITestService {
    ErrorAndVOTuple<IVo> addTest(TestDo testDo);

    ErrorAndVOTuple<TestListPageVo> listTest(TestNameParams params);
}

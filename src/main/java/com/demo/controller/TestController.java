package com.demo.controller;


import com.demo.common.sms.SMSService;
import com.demo.common.util.ErrorAndVOTuple;
import com.demo.common.util.ResponseUtil;
import com.demo.common.util.ResponseVO;
import com.demo.entity.TestDo;
import com.demo.model.param.TestNameParams;
import com.demo.model.vo.IVo;
import com.demo.model.vo.TestListPageVo;
import com.demo.service.ITestService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DengCe
 * @date 2020/6/23 11:10
 * @description
 */
@Slf4j
@RestController
@RequestMapping("test/")
public class TestController {

    @Autowired
    private ITestService iTestService;


    @Autowired
    private SMSService smsService;


    /**
     * 写了一个测试的修改提交
     * @param phoneNumber
     * @param content
     * @return
     */

    //发短信
    @RequestMapping("sendmessage")
    public int ajaxSmsSendMessage(@RequestBody String phoneNumber,String content){
        log.info("content+phoneNumber",content+phoneNumber);
        int num = 0;
        try {
            String[] split = phoneNumber.split(",");
            for (int i = 0; i < split.length; i++) {
                String messageSend = smsService.sendSMS(split[i], content);
                if(messageSend!="" && messageSend!=null) {
                    num++;
                }
            }
            return num;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }








    /**
     * @param testDo
     * @return
     */
    @RequestMapping("/add_test")
    public ResponseVO<IVo> addTest(@RequestBody TestDo testDo) {
        ResponseVO<IVo> responseVO = null;
        try {
            log.info("userExists params:{}", testDo);
            ErrorAndVOTuple<IVo> vo = iTestService.addTest(testDo);
            responseVO = ResponseUtil.get(vo.code, vo.msg, vo.data);
            log.info("userExists vo:{}", vo);
        } catch (Exception e) {
            responseVO = ResponseUtil.error(new IVo());
            log.info("userExists error:{}", e);
        }
        return responseVO;
    }


    @RequestMapping("/list")
    public ResponseVO<TestListPageVo> list(TestNameParams params) {
        if (params.getPageNumber() == null) {
            params.setPageNumber("1");
        }
        if (params.getPageSize() == null) {
            params.setPageSize("10");
        }
        ResponseVO<TestListPageVo> responseVO = null;
        try {
            log.info("list params:{}", params);
            ErrorAndVOTuple<TestListPageVo> vo = iTestService.listTest(params);
            responseVO = ResponseUtil.get(vo.code, vo.msg, vo.data);
            log.info("list vo:{}", vo);
        } catch (Exception e) {
            responseVO = ResponseUtil.error(new TestListPageVo());
            log.info("list error:{}", e);
        }
        return responseVO;
    }
}







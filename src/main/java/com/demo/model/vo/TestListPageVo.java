package com.demo.model.vo;

import com.demo.common.constant.vo.PageVO;
import com.demo.entity.TestDo;
import lombok.Data;

import java.util.List;

@Data
public class TestListPageVo {
    private List<TestDo> list;

    private PageVO page;
}

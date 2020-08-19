package com.demo.common.constant.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;


/**
 * PageVO
 *
 * @author yinruidong
 * @date 2019/3/20
 * @description 分页信息
 */
@Data
public class PageVO {

    public PageVO(PageInfo pageInfo) {
        this.pageNumber = String.valueOf(pageInfo.getPageNum());
        this.pageSize = String.valueOf(pageInfo.getPageSize());
        this.pageTotal = String.valueOf(pageInfo.getPages());
        this.recordTotal = String.valueOf(pageInfo.getTotal());
    }

    public PageVO() {}

    /**
     * 页码
     */
    private String pageNumber;
    /**
     * 行数
     */
    private String  pageSize;
    /**
     * 总页数
     */
    private String  pageTotal;
      /**
     * 总条数
     */
    private String  recordTotal;

}

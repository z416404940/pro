package com.majortom.commons;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 老九.大师兄
 * @version 1.0
 * @desc
 * @date 2019/12/20-16:31
 * @copyright &copy; xuetang9
 * @address 成都市西部国际金融中心2栋2201
 */
public class PageBean<T> {
    private Integer pageSize;
    private Integer currentPage;
    private Integer pageHome = 1;
    private Integer pageUp;
    private Integer pageDown;
    private Integer pageEnd;
    private List<T> datas;
    private List<Integer> pageNums;

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageHome() {
        return pageHome;
    }

    public void setPageHome(Integer pageHome) {
        this.pageHome = pageHome;
    }

    public Integer getPageUp() {
        return pageUp;
    }

    public void setPageUp(Integer pageUp) {
        this.pageUp = pageUp;
    }

    public Integer getPageDown() {
        return pageDown;
    }

    public void setPageDown(Integer pageDown) {
        this.pageDown = pageDown;
    }

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    /**
     * 计算呈现页码
     * @return
     */
    public List<Integer> getPageNums() {
        pageNums = new ArrayList<>();
        // 定义变量表示每页显示的页码数量
        int pageNumCount = 9;
        int start = 0;
        // 计算页码的起点 ( 以5为页码单位起点)
        start = currentPage - (currentPage % 5);
        start += 1;
        int end = pageEnd > (start + pageNumCount)?(start + pageNumCount) : (pageEnd);
        for (int i = start; i <= end; i++) {
            pageNums.add(i);
        }
        return pageNums;
    }

}

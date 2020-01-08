package manual.beans;

import java.util.List;

/**
 * @author 郑文斌Mz
 * @version 1.0.0
 * @date 2019/12/2510:22
 * @copyright &copy; <a href="http://www.xuetang9.com">老九学堂</a> 版权所有
 * @address 成都市西部国际金融中心2栋2201老九学堂
 */
public class PageBean<T> {
    private Integer pageSize;
    private Integer currentPage;
    private Integer pageHome;
    private Integer pageEnd;
    private Integer pageUp;
    private Integer pageDown;
    private List<T> datas;

    public PageBean() {
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
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

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}

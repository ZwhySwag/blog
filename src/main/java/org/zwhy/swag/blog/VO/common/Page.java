package org.zwhy.swag.blog.VO.common;

import java.util.List;

/**
 * @author ZWHySwag
 * @date 2021\7\30 0030 17:36
 */
public class Page<T> {

    private Integer page = 1;

    private Integer pageSize = 10;

    private List<T> records;

    private Long total;

    public Page(Integer page, Integer pageSize, List<T> records, Long total) {
        this.page = page;
        this.pageSize = pageSize;
        this.records = records;
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}

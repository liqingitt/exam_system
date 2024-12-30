package com.liqingitt.exam_system.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

@Data
public class PageResDto<T> {
    private long total;
    private long currentPage;
    private long pageSize;
    private List<T> data;

    static public <T> PageResDto<T> createPageResDto(Page<T> page) {
        PageResDto<T> objectPageResDto = new PageResDto<>();
        objectPageResDto.setTotal(page.getTotal());
        objectPageResDto.setCurrentPage(page.getCurrent());
        objectPageResDto.setPageSize(page.getSize());
        objectPageResDto.setData(page.getRecords());

        return objectPageResDto;
    }

    static public <T> PageResDto<T> createPageResDto(Page<Object> page,List<T> data) {
        PageResDto<T> objectPageResDto = new PageResDto<>();
        objectPageResDto.setTotal(page.getTotal());
        objectPageResDto.setCurrentPage(page.getCurrent());
        objectPageResDto.setPageSize(page.getSize());
        objectPageResDto.setData(data);

        return objectPageResDto;
    }
}

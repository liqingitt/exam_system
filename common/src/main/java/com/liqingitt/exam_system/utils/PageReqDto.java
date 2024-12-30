package com.liqingitt.exam_system.utils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageReqDto {

    private long currentPage;

    private long pageSize;

    static public <T> Page<T> toPageObj(PageReqDto pageReqDto) {
        return new Page<>(pageReqDto.getCurrentPage(), pageReqDto.getPageSize());
    }

}

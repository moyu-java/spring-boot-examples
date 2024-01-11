package com.junmoyu.example.restful.model.base;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

/**
 * 分页返回结果
 *
 * @author 莫语
 */
@Data
@Builder
@NoArgsConstructor
public class PageResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -4136474757414698827L;

    private int total;

    private Collection<T> list;

    public PageResult(int total) {
        this(total, Collections.emptyList());
    }

    public PageResult(int total, Collection<T> list) {
        this.total = total;
        this.list = list;
    }

    public boolean isEmpty() {
        return list == null || list.isEmpty();
    }
}

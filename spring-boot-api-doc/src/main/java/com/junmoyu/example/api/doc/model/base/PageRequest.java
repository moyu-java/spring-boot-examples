package com.junmoyu.example.api.doc.model.base;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 基础分页查询对象
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 437062142215284866L;

    @NotNull(message = "分页页码不能为空")
    @Min(value = 1, message = "分页页码不能小于1")
    private Integer page;

    @NotNull(message = "每页显示条数不能为空")
    @Min(value = 1, message = "每页显示条数不能小于1")
    @Max(value = 100, message = "每页显示条数不能大于100")
    private Integer pageSize;

    /**
     * 获取偏移值
     *
     * @return 偏移值
     */
    public int getOffset() {
        return (getPage() - 1) * getPageSize();
    }
}
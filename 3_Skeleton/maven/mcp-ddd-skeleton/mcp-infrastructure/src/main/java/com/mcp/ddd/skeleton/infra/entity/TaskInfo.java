package com.mcp.ddd.skeleton.infra.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author KG
 * @since 2022-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TaskInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * task name
     */
    private String name;

    /**
     * task description
     */
    private String description;

    /**
     * FK - user_info
     */
    private Integer userId;

    /**
     * FK - status_info
     */
    private Integer statusId;

    /**
     * task start time
     */
    private LocalDateTime startTime;

    /**
     * task end time
     */
    private LocalDateTime endTime;

    /**
     * record create time
     */
    private LocalDateTime createTime;

    /**
     * record last update
     */
    private LocalDateTime lastUpdate;


}

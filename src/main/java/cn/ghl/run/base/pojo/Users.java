package cn.ghl.run.base.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@ApiModel(value = "pojo-Users")
@Data
@TableName(value = "users")
@EqualsAndHashCode(callSuper = false)
@ToString
public class Users {
    @TableId(value = "userid", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Integer userid;

    @TableField(value = "username")
    @ApiModelProperty(value = "")
    private String username;

    @TableField(value = "usersex")
    @ApiModelProperty(value = "")
    private String usersex;

    @TableField(value = "created_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime createdTime;

    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    //yyyy-MM-dd HH:mm:ss
    //接受大小写不敏感的值,
    private LocalDateTime updatedTime;

    @TableField(value = "deleted_ind", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "")
    private Byte deletedInd;

    @TableField(value = "vaild_ind", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "")
    private Byte vaildInd;
}
package com.pxy.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体类")
public class User {

    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("电话号码")
    private String phone;
}

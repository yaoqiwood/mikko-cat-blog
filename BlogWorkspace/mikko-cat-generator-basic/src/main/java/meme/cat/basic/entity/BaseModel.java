package meme.cat.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class BaseModel {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
}

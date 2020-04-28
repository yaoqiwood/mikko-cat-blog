package com.summer.cat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.summer.cat.entity.BlogTag;

/**
 * <p>
 * Tag表 Mapper 接口
 * </p>
 *
 * @author SummerCat
 * @since 2020-04-23
 */
public interface BlogTagMapper extends BaseMapper<BlogTag> {
    int insertTagByIgnoreIfExistTagName(BlogTag blogTag);

    /**
     * 查询Tags通过当前文章id
     * @param blogArticleId
     * @return
     */
    List<BlogTag> selectTagsByArticleId(@Param("blogArticleId") String blogArticleId);
}

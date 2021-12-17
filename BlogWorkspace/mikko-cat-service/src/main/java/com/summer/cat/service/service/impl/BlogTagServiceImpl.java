package com.summer.cat.service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.cat.entity.BlogTag;
import com.summer.cat.mapper.BlogTagMapper;
import com.summer.cat.service.service.IBlogTagService;

/**
* <p>
	* Tag表 服务实现类
	* </p>
*
* @author SummerCat
* @since 2020-04-23
*/
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements IBlogTagService {

    @Override
    public QueryWrapper<BlogTag> buildWrapper(BlogTag var) {
        return null;
    }

    /**
     * 插入tag（如果存在相同名称则忽略，并且更新tag的颜色）
     * @param blogTag
     * @return
     */
    @Override
    public int insertTagByIgnoreIfExistTagName(BlogTag blogTag) {
        return baseMapper.insertTagByIgnoreIfExistTagName(blogTag);
    }

    /**
     * 根据文章id获取相关文章tag
     * @param id
     * @return
     */
    @Override
    public List<BlogTag> selectTagsByArticleId(String id) {
        return baseMapper.selectTagsByArticleId(id);
    }

}

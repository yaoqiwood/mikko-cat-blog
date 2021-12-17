package meme.cat.basic.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.summer.cat.base.Constant;
import com.summer.cat.util.Returns;

import lombok.extern.slf4j.Slf4j;
import meme.cat.basic.service.BaseService;
import meme.cat.basic.util.GsonUtil;

@Slf4j
public class BaseController<T, SERVICE extends BaseService<T>> {

    @Autowired
    protected SERVICE service;

    private Class<T> searchClass;

    public BaseController(Class<T> searchClass) {
        this.searchClass = searchClass;
    }

    @PostMapping(value = { "searchItems" })
    public @ResponseBody Map<String, ?> search(@RequestParam long page, @RequestParam long rows,
                                               @RequestParam(required = false) String exampleJson) {
        try {
            T item = null;
            if (!Strings.isNullOrEmpty(exampleJson)) {
                item = GsonUtil.gson2Bean(exampleJson, this.searchClass);
            }
            QueryWrapper<T> q = null;
            if (null != item) {
                q = this.service.buildWrapper(item);
            }
            IPage<T> rowsItems = this.service.page(new Page<T>(page, rows), q);
            return Returns.mapOk(rowsItems.getRecords(), rowsItems.getTotal(), "搜索成功");
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }

    @PostMapping(value = { "findItemById" })
    public @ResponseBody Map<String, ?> findItemById(@RequestParam String id) {
        try {
            return Returns.mapOk(this.service.getById(id), Constant.ReturnsMessage.SUCCESS);
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }

    @PostMapping(value = { "createItem" })
    public @ResponseBody Map<String, ?> createItem(@RequestBody T item) {
        try {
            return Returns.mapOk(this.service.save(item), Constant.ReturnsMessage.SUCCESS);
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }

    @PostMapping(value = { "updateItem" })
    public @ResponseBody Map<String, ? extends Object> updateItem(@RequestBody T item) {
        try {
            return Returns.mapOk(this.service.updateById(item), Constant.ReturnsMessage.SUCCESS);
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }

    @PostMapping(value = { "deleteItemById" })
    public @ResponseBody Map<String, ?> deleteItemById(@RequestParam String id) {
        try {
            return Returns.mapOk(this.service.removeById(id), Constant.ReturnsMessage.SUCCESS);
        } catch (Exception e) {
            log.error(Constant.ReturnsMessage.ERROR_MSG, e);
            return Returns.mapError(Constant.ReturnsMessage.ERROR_MSG + e.getMessage());
        }
    }
}

package com.summer.cat.controller;

import java.io.*;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.summer.cat.annotation.Pass;
import com.summer.cat.base.Constant;
import com.summer.cat.base.SystemConfig;
import com.summer.cat.entity.SysAnnexConfigInfo;
import com.summer.cat.service.ISysAnnexConfigInfoService;
import com.summer.cat.util.CatsException;
import com.summer.cat.util.HttpUtil;
import com.summer.cat.util.LogUtil;
import com.summer.cat.util.Returns;

import cn.hutool.core.io.FileUtil;

/**
 * <p>
 * 系统附件表 前端控制器
 * </p>
 *
 * @author summerCats
 * @since 2020-01-19
 */
@Controller
@RequestMapping("/sysAnnexConfigInfo")
public class SysAnnexConfigInfoController {
    protected Gson gson = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Autowired
    ISysAnnexConfigInfoService service;

    @RequestMapping("search.action")
    @Pass
    public @ResponseBody Map<String, ? extends Object> search(@RequestParam int page, @RequestParam int rows,
            @RequestParam(required = false) String exampleJson, HttpSession session) {
        SysAnnexConfigInfo item = new SysAnnexConfigInfo();
        if (!Strings.isNullOrEmpty(exampleJson)) {
            item = gson.fromJson(exampleJson, SysAnnexConfigInfo.class);
        }
        Wrapper<SysAnnexConfigInfo> wrapper = null;
        if (null != item) {
            wrapper = this.service.buildWrapper(item);
        }
        Page<SysAnnexConfigInfo> items = this.service.selectPage(new Page<>(page, rows), wrapper);
        return Returns.mapOk(items.getRecords(), items.getTotal(), Constant.ReturnsMessage.SUCCESS_MSG);
    }

    @GetMapping("downloadImgById.action")
    @Pass
    public void downloadImgById(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            request.setCharacterEncoding(Charsets.UTF_8.name());
            SysAnnexConfigInfo annexConfigInfo = this.service.selectById(id);
            String path = SystemConfig.systemUploadDir + annexConfigInfo.getSaciStoragePath()
                    + annexConfigInfo.getSaciNewAnnexName();
            if (!FileUtil.exist(path)) {
                LogUtil.info("文件不存在,路径:" + path);
                throw new CatsException("文件不存在,路径：" + path);
            }
            File downloadFile = new File(path);
            long fileLong = downloadFile.length();
            response.setHeader(HttpUtil.HEADER_CONTENT_DISPOSITION, HttpUtil.ATTACHMENT_FILENAME + new String(
                    annexConfigInfo.getSaciNewAnnexName().getBytes(Charsets.UTF_8.name()), Charsets.ISO_8859_1.name()));
            response.setHeader(HttpUtil.HEADER_CONTENT_LENGTH, String.valueOf(fileLong));
            bis = new BufferedInputStream(new FileInputStream(path));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int byteRead;
            while (-1 != (byteRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, byteRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }
}

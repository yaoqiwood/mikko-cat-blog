package com.summer.cat.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.summer.cat.base.BusinessException;
import com.summer.cat.base.Constant;
import com.summer.cat.base.PublicResultConstant;
import com.summer.cat.config.ResponseHelper;
import com.summer.cat.config.ResponseModel;
import com.summer.cat.util.ComUtil;
import com.summer.cat.util.FileUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author summer
 * @since on 2018/5/11.
 */
@RestController
@RequestMapping("/resource")
// 不加入swagger ui里
@ApiIgnore
public class ResourceController {

    @PostMapping
    public ResponseModel uploadResource(@RequestParam("files") MultipartFile[] multipartFiles) throws Exception {
        List<String> filePaths = new ArrayList<>();
        if (!ComUtil.isEmpty(multipartFiles) && multipartFiles.length != 0) {
            for (MultipartFile multipartFile : multipartFiles) {
                int fileType = FileUtils.getFileType(multipartFile.getOriginalFilename());
                filePaths.add(FileUtils.saveFile(multipartFile.getInputStream(), fileType,
                        multipartFile.getOriginalFilename(), null));
            }
        }
        return ResponseHelper.buildResponseModel(filePaths);
    }

    @ApiOperation(value = "上传图片,返回原图和缩略图", notes = "文件MultipartFile类型", produces = "application/from-data")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "文件", required = true, dataType = "MultipartFile", paramType = "form") })
    @PostMapping("/thumbnail")
    public ResponseModel uploadThumbnail(@RequestParam("imgs") MultipartFile[] multipartFiles) throws Exception {
        List<HashMap> filePaths = new ArrayList<>();
        if (!ComUtil.isEmpty(multipartFiles) && multipartFiles.length != 0) {
            for (MultipartFile multipartFile : multipartFiles) {
                String postFix = multipartFile.getOriginalFilename()
                        .split("//.")[multipartFile.getOriginalFilename().split("//.").length - 1];
                if (Arrays.asList(Constant.FilePostFix.IMAGES).contains(postFix)) {
                    throw new BusinessException("请上传图片");
                }
                HashMap<String, String> retMap = new HashMap<>();
                String url = FileUtils.saveFile(multipartFile.getInputStream(), 1, multipartFile.getOriginalFilename(),
                        null);
                retMap.put("url", url);
                retMap.put("preUrl", url);
                // 大于2m时启动图片压缩
                if (multipartFile.getSize() >= FileUtils.FILE_SIZE) {
                    String preUrl = FileUtils.savePreFile(url);
                    retMap.put("preUrl", preUrl);
                }
                filePaths.add(retMap);
            }
        }
        return ResponseHelper.buildResponseModel(filePaths);
    }

    @DeleteMapping
    public ResponseModel deleteResource(@RequestParam("filePaths") List<String> filePaths) {
        if (!ComUtil.isEmpty(filePaths) && filePaths.size() != 0) {
            for (String item : filePaths) {
                if (!FileUtils.deleteUploadedFile(item)) {
                    return ResponseHelper.validationFailure(PublicResultConstant.ERROR);
                }
            }
        }
        return ResponseHelper.buildResponseModel(filePaths);
    }

}

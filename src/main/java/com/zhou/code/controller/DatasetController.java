package com.zhou.code.controller;


import com.zhou.code.bean.Dataset;
import com.zhou.code.bean.User;
import com.zhou.code.error.AddException;
import com.zhou.code.service.IDatasetService;
import com.zhou.code.service.IUserService;
import com.zhou.code.util.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
@RestController
@RequestMapping("/dataset")
@CrossOrigin
public class DatasetController {
    @Value("${file.upload.path}")
    private String filePath;
    @Autowired
    IDatasetService datasetService;
    @RequestMapping("/all")
    @ApiOperation(value = "dataset",httpMethod ="GET", notes = "返回所有数据集信息")
    public Result all(HttpServletRequest request) {
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("请登录");
        }
        if(cur_user.getUserRole()==0){
            List<Dataset> list = datasetService.list();
            return Result.success(list);
        }else{
            List<Dataset> list = datasetService.getDatasetByUserId(cur_user.getUserId());
            return Result.success(list);
        }

    }
    @PostMapping("/one")
    @ApiOperation(value = "dataset", notes = "添加数据集信息")
    public Result one(Dataset dataset, @RequestParam("file") MultipartFile[] srcfiles, HttpServletRequest request) throws IOException {
        MultipartFile[] files = srcfiles;
        int length = files.length;
        String path = DatasetController.this.filePath + "/dataset/";
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("还未登录");
        }
        Integer userId = cur_user.getUserId();
        dataset.setDatasetId(datasetService.getLastId()+1);
        File zipFile=new File(path +userId+"_"+dataset.getDatasetId()+"_"+dataset.getDatasetName()+".zip");
        if(zipFile.exists()){
            return new Result().setCode(999).setData("数据集已存在");
        }
        dataset.setDatasetUrl(path +userId+"_"+dataset.getDatasetId()+"_"+dataset.getDatasetName()+".zip");
        File filepath = new File(path, userId+"_"+dataset.getDatasetId()+"_"+dataset.getDatasetName()+".zip");
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        // 创建 ZipOutputStream
        ZipOutputStream zipOutputStream = null;
        // 创建 FileInputStream 对象
        FileInputStream fileInputStream = null;
        if (!zipFile.exists()) {
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return new Result().setCode(999).setData("数据集已存在");
            }
        }
        try {
            fileOutputStream = new FileOutputStream(zipFile);
        }catch (FileNotFoundException fileUploadException){
           throw  fileUploadException;
        }
            // 实例化 ZipOutputStream 对象
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            // 创建 ZipEntry 对象
            ZipEntry zipEntry = null;
            // 遍历源文件数组
            for (int i = 0; i < length; ++i) {
                MultipartFile file = files[i];
                InputStream inputStream = file.getInputStream();
                zipEntry = new  ZipEntry(files[i].getOriginalFilename());
                zipOutputStream.putNextEntry(zipEntry);
                int len;
                byte[] buffer=new byte[1024];
                while((len =  inputStream.read(buffer)) > 0){
                    zipOutputStream.write(buffer, 0,  len);
                }
                inputStream.close();
            }
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        fileOutputStream.close();
        dataset.setUserId(userId);
        dataset.setCreateTime(LocalDateTime.now());
        dataset.setUpdateTime(LocalDateTime.now());
        dataset.setDeleted(false);
        boolean save = datasetService.save(dataset);
        if(save){
            return Result.success("添加成功！");
        } else{
            throw new AddException("添加失败");
        }
    }

    @DeleteMapping(value="/one")
    public Result delete(HttpServletRequest request,Integer datasetId){
        Dataset dataset = datasetService.getById(datasetId);
        dataset.setDeleted(true);
        String path = DatasetController.this.filePath + "/dataset/";
        User cur_user = (User)request.getSession().getAttribute("cur_user");
        if(cur_user==null){
            return new Result().setCode(999).setData("还未登录");
        }
        Integer userId = cur_user.getUserId();
        boolean b = datasetService.updateById(dataset);
        if(dataset.getDatasetUrl()!=null){
            File filepath = new File(path, userId+"_"+dataset.getDatasetId()+"_"+dataset.getDatasetName()+".zip");
            filepath.delete();
        }
        if(b){
            return new Result().setCode(200).setData("删除成功");
        }else{
            return new Result().setCode(999).setData("删除失败");
        }

    }
}


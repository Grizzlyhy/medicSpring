package com.zhou.code.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;
import com.alibaba.fastjson.JSON;
import com.zhou.code.bean.Algorithm;
import com.zhou.code.bean.CaseImage;
import com.zhou.code.bean.Dataset;
import com.zhou.code.bean.User;
import com.zhou.code.error.AddException;
import com.zhou.code.service.IAlgorithmService;
import com.zhou.code.service.ICaseImageService;
import com.zhou.code.util.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoulixin
 * @since 2022-03-04
 */
@RestController
@RequestMapping("/algorithm")
@Api(protocols = "http,https", produces = "application/json", tags = "algorithm")
@CrossOrigin
public class AlgorithmController {
        @Value("${file.upload.path}")
        private String filePath;
        @Autowired
        IAlgorithmService algorithmService;
        @RequestMapping("/all")
        @ApiOperation(value = "algorithm",httpMethod ="GET", notes = "返回所有算法模型信息")
        public Result all(HttpServletRequest request) {
                User cur_user = (User)request.getSession().getAttribute("cur_user");
                if(cur_user==null){
                        return new Result().setCode(999).setData("请登录");
                }
                if(cur_user.getUserRole()==0){
                        List<Algorithm> list = algorithmService.list();
                        return Result.success(list);
                }else{
                        List<Algorithm> list = algorithmService.getAlgorithmByUserId(cur_user.getUserId());
                        List<Algorithm> results=new LinkedList<>();
                        for (int i = 0; i < list.size(); i++) {
                            if(list.get(i).getDeleted()==0){
                                    results.add(list.get(i));
                            }
                        }
                        return Result.success(results);
                }
        }
        @PostMapping("/one")
        @ApiOperation(value = "algorithm",httpMethod ="POST", notes = "添加算法模型信息")
        public Result one( Algorithm algorithm,@RequestParam("file") MultipartFile[] srcfiles, HttpServletRequest request) {
                MultipartFile[] files = srcfiles;
                String path = AlgorithmController.this.filePath + "/algorithm/";
                User cur_user = (User)request.getSession().getAttribute("cur_user");
                if(cur_user==null){
                        return new Result().setCode(999).setData("还未登录");
                }
                Integer userId = cur_user.getUserId();
                MultipartFile[] var5 = files;
                int var6 = var5.length;
                if(var6<=0){
                        return new Result().setCode(999).setData("未添加任何文件");
                }
                algorithm.setAlgorithmId(algorithmService.getLastId()+1);
                StringBuffer sb=new StringBuffer();
                sb.append(path+cur_user.getUserId()+"_"+algorithm.getAlgorithmId()+"_"+algorithm.getAlgorithmName()+"_"+";");
                for(int var7 = 0; var7 < var6; ++var7) {
                        MultipartFile file = var5[var7];
                        String filename = file.getOriginalFilename();
                        File filepath = new File(path, cur_user.getUserId()+"_"+algorithm.getAlgorithmId()+"_"+algorithm.getAlgorithmName()+"_"+var7+"_"+filename);
                        if (!filepath.getParentFile().exists()) {
                                filepath.getParentFile().mkdirs();
                                filepath.delete();
                        }
                        try {
                                file.transferTo(new File(path+cur_user.getUserId()+"_"+algorithm.getAlgorithmId()+"_"+algorithm.getAlgorithmName()+"_"+var7+"_"+filename));
                                sb.append(var7+"_"+filename+";");
                        } catch (IOException var13) {
                                var13.printStackTrace();
                        }
                }
                algorithm.setAlgorithmUrl(sb.toString());
                algorithm.setCreateTime(LocalDateTime.now());
                algorithm.setUpdateTime(LocalDateTime.now());
                algorithm.setDeleted(0);
                boolean save = algorithmService.save(algorithm);
                if(save){
                        return Result.success("添加成功！");
                } else{
                        throw new AddException("添加失败");
                }
        }
        @DeleteMapping(value="/one")
        public Result delete(HttpServletRequest request, Integer algorithmId){
                Algorithm algorithm = algorithmService.getById(algorithmId);
                algorithm.setDeleted(1);
                String path = AlgorithmController.this.filePath + "/algorithm/";
                User cur_user = (User)request.getSession().getAttribute("cur_user");
                if(cur_user==null){
                        return new Result().setCode(999).setData("还未登录");
                }
                Integer userId = cur_user.getUserId();
                boolean b = algorithmService.updateById(algorithm);
                if(algorithm.getAlgorithmUrl()!=null){
                        String[] paths=algorithm.getAlgorithmUrl().split(";");
                        String head=paths[0];
                        for (int i =1; i < paths.length; i++) {
                                File f=new File(head+paths[i]);
                                f.delete();
                        }
                }
                if(b){
                        return new Result().setCode(200).setData("删除成功");
                }else{
                        return new Result().setCode(999).setData("删除失败");
                }

        }
        @PostMapping(value="/runResNet50")
        public Result runResNet50() throws IOException, InterruptedException {

                final ProcessBuilder processBuilder = new ProcessBuilder("C:\\Users\\10502\\miniconda3\\envs\\py37\\"+"python",
                        "G:\\hello.py","G:\\Test\\2020-539-PASM-1_0.jpg");
                processBuilder.redirectErrorStream(true);
                final Process process = processBuilder.start();
                final BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String s = null;

                while ((s = in.readLine()) != null)
                {

                        return new Result().setCode(200).setData(s);
                }

                final int exitCode = process.waitFor();
                return new Result().setData(999).setData(s);
        }


}


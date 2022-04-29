package com.zhou.code.advice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhou.code.bean.BrowsingRecord;
import com.zhou.code.service.IBrowsingRecordService;
import com.zhou.code.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    IBrowsingRecordService iBrowsingRecordService;
    private static final String KEY = "d7b85f6e214abcda";
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (serverHttpRequest.getHeaders() != null && serverHttpRequest.getHeaders().size() > 0) {
            try {

                ServletServerHttpRequest ssReq = (ServletServerHttpRequest)serverHttpRequest;
                HttpServletRequest req = ssReq.getServletRequest();
                if (true)//req.getParameter("decrypt")!=null) {//根据请求参数判断需不需要加密
                {
                    if (body!=null) {
//                        if(body instanceof Result){
//                          Result r=(Result)body;
//                          System.out.println("---------------->"+r);
//                          String jsonStr=JSONObject.toJSONString(r.getData());
//                          System.out.println("--------->"+jsonStr);
//                          String respTxt = AesEncryptUtil.aesEncrypt(jsonStr,KEY);
//                          System.out.println(respTxt);
//                          r.setData(respTxt);
//                          return r;
//                        }
                        if(body instanceof Result){
                            Result result=(Result)body;
                            BrowsingRecord browsingRecord = new BrowsingRecord();
                            browsingRecord.setIp(serverHttpRequest.getRemoteAddress().toString());
                            browsingRecord.setOperationAction(serverHttpRequest.getMethod().toString());
                            browsingRecord.setOperationTime(LocalDateTime.now());
                            browsingRecord.setOperationResult(result.getCode()+"");
                            browsingRecord.setPageUrl(serverHttpRequest.getURI().toString());
                            iBrowsingRecordService.save(browsingRecord);
                        }
                        return body;
                    }
                 }
            } catch (Exception e) {
                    e.printStackTrace();
                    return body;
                    }
                }


        return body;
        /*if(body instanceof String){
            try {
                System.out.println("String---------------->"+body);
                return objectMapper.writeValueAsString(Result.success(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //返回类型是否已经封装
        if(body instanceof Result){
            System.out.println("Result----------------->"+body);
            return body;
        }
        return Result.success(body);*/
    }
}
package org.garen.cas.remote;


import org.garen.cas.util.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.*;

@Component
public class RestTemplateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateUtil.class);

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

    private static RestTemplate restTemplate;

    static {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(20000);
        requestFactory.setConnectTimeout(20000);

        // 添加转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(new MediaType[]{MediaType.ALL, MediaType.TEXT_PLAIN, MediaType.APPLICATION_OCTET_STREAM}));
        messageConverters.add(converter);
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        restTemplate = new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(requestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

        LOGGER.info("SimpleRestClient初始化完成");
    }


    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public <T> T post(String url, Map<String, Object> param, Class<T> responseType) throws HttpServerErrorException {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        param.keySet().stream().forEach(key -> requestEntity.add(key, String.valueOf(param.get(key))));
        return restTemplate.postForObject(url, requestEntity, responseType);
    }


//    public <T> T post(String url,MultiValueMap<String, Object> param, Class<T> responseType) throws HttpServerErrorException {
//
//        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(param, httpHeaders);
//        return restTemplate.postForObject(url, param, responseType);
//    }

    public <T> T post(String url,MultiValueMap<String, Object> param, Class<T> responseType) throws HttpServerErrorException {
        HttpHeaders headers = new HttpHeaders();
//        headers.add("Accept", "application/json");
        headers.add("Accpet-Encoding", "gzip");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "multipart/form-data");

        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(param, headers);

        return restTemplate.postForObject(url, formEntity, responseType);
    }

//    public <T> T post(String url,MultiValueMap<String, Object> param, Class<T> responseType) throws HttpServerErrorException {
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.parseMediaType("multipart/form-data; charset=UTF-8"));
////        httpHeaders.add("Content-Type","multipart/form-data");
////        httpHeaders.add("consumes","multipart/form-data");
////        httpHeaders.add("produces","application/json");
//
//
//        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<MultiValueMap<String, Object>>(param, httpHeaders);
//
//        return restTemplate.postForObject(url, formEntity, responseType);
//
//
////        return restTemplate.postForObject(url, param, responseType);
//    }

    public String post(String url, String  params) {
        ResponseEntity<String> rss = request(null, url, HttpMethod.POST, params);
        return rss.getBody();
    }

    public String post(Map<String, String> header, String url, Map<String, String>  params) {
        ResponseEntity<String> rss = request(header, url, HttpMethod.POST, params);
        return rss.getBody();
    }
    public String post(Map<String, String> header, String url, String  params) {
        ResponseEntity<String> rss = request(header, url, HttpMethod.POST, params);
        return rss.getBody();
    }

    public String get(Map<String, String> header, String url, Map<String, String>  params) {
        ResponseEntity<String> rss = request(header, url, HttpMethod.GET, params);
        return rss.getBody();
    }

    public <T> T get(String url, Class<T> responseType, Map<String, String>  params) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, responseType, params);
    }

    public String get(Map<String, String> header, String url, String contentType, Map<String, String>  params) {
        MediaType mediaType = MediaType.parseMediaType(contentType);
        return get(header, url, mediaType, params);
    }

    public String get(Map<String, String> header, String url, MediaType mediaType, Map<String, String>  params) {
        ResponseEntity<String> rss = request(header, url, HttpMethod.GET, mediaType, params);
        return rss.getBody();
    }

    public ResponseEntity<byte[]> down(Map<String, String> header, String url) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
            for (Map.Entry<String, String> entry : header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                headers.add(key, value);
            }

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

//            byte[] result = response.getBody();

//            inputStream = new ByteArrayInputStream(result);

//            File file = new File("/Users/apple/Desktop/test3.jpg");
//            if (!file.exists()) {
//                file.createNewFile();
//            }

//            outputStream = new FileOutputStream(file);
//            int len = 0;
//            byte[] buf = new byte[1024];
//            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
//                outputStream.write(buf, 0, len);
//            }
//            outputStream.flush();
            return response;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public ResponseEntity<byte[]> downExcel(Map<String, String> header, String url) {
        try {
            HttpHeaders headers = new HttpHeaders();
            for (Map.Entry<String, String> entry : header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                headers.add(key, value);
            }

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String delete(Map<String, String> header, String url, Map<String, String>  params) {
        ResponseEntity<String> rss = request(header, url, HttpMethod.DELETE, params);
        return rss.getBody();
    }

    public String delete(Map<String, String> header, String url, String contentType, Map<String, String>  params) {
        MediaType mediaType = MediaType.parseMediaType(contentType);
        return delete(header, url, mediaType, params);
    }

    public String delete(Map<String, String> header, String url, MediaType mediaType, Map<String, String>  params) {
        ResponseEntity<String> rss = request(header, url, HttpMethod.DELETE, mediaType, params);
        return rss.getBody();
    }

    public String put(Map<String, String> header, String url, Map<String, String>  params) {
        ResponseEntity<String> rss = request(header, url, HttpMethod.PUT, params);
        return rss.getBody();
    }


    public String put(Map<String, String> header, String url, String  params) {
        ResponseEntity<String> rss = request(header, url, HttpMethod.PUT, params);
        return rss.getBody();
    }


    /**
     * @param header
     * @param url
     * @param method
     * @param params maybe null
     * @return
     */
    private ResponseEntity<String> request(Map<String, String> header, String url, HttpMethod method, Map<String, String> params) {
        MediaType mediaType = MediaType.parseMediaType("application/json; charset=UTF-8");
        return request(header, url, method, mediaType, params);
    }

    /**
     * @param header
     * @param url
     * @param method
     * @param params maybe null
     * @return
     */
    private ResponseEntity<String> request(Map<String, String> header, String url, HttpMethod method, MediaType mediaType, Map<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( mediaType);
        for (Map.Entry<String, String> entry : header.entrySet()) {
            String key    = entry.getKey();
            String value  = entry.getValue();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            headers.add(key, value);
        }

        RestTemplate restTemplate = new RestTemplate();
        String requestJson = JsonMapper.nonDefaultMapper().toJson(params);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        return restTemplate.exchange(url, method, entity, String.class);
    }

    /**
     * @param header
     * @param url
     * @param method
     * @param requestJson maybe null
     * @return
     */
    private ResponseEntity<String> request(Map<String, String> header, String url, HttpMethod method, String requestJson) {
        if(ObjectUtils.isEmpty(header)){
            header = new HashMap<>();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.parseMediaType("application/json; charset=UTF-8") );
        for (Map.Entry<String, String> entry : header.entrySet()) {
            String key    = entry.getKey();
            String value  = entry.getValue();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            headers.add(key, value);
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        return restTemplate.exchange(url, method, entity, String.class);

    }

    /**
     * @param header
     * @param url
     * @param method
     * @param requestJson maybe null
     * @return
     */
    public ResponseEntity<String> requestData(Map<String, String> header, String url, HttpMethod method, String requestJson) {
        if(ObjectUtils.isEmpty(header)){
            header = new HashMap<>();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.parseMediaType("application/json; charset=UTF-8") );
        for (Map.Entry<String, String> entry : header.entrySet()) {
            String key    = entry.getKey();
            String value  = entry.getValue();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            headers.add(key, value);
        }

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        return restTemplate.exchange(url, method, entity, String.class);

    }

    /**
     * @param header
     * @param url
     * @param requestJson maybe null
     * @return
     */
    public String getRequest(Map<String, String> header, String url, String requestJson) {
        ResponseEntity<String> rss = requestData(header, url, HttpMethod.GET, requestJson);
        return rss.getBody();
    }

}

package com.sakura.ofm.tools;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author y14
 * @date 2018-01-19
 * 配置文件工具类
 */
@Component
public class PropertiesHelper {

    private static Map<String,String> propertiesParam = new HashMap<>();

    public PropertiesHelper(){
        try{
            Properties properties = new Properties();
            properties.load(this.getClass().getResource("/config/system.properties").openStream());
            Iterator<Map.Entry<Object,Object>> iterator = properties.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Object, Object> entry = iterator.next();
                String key = (String) entry.getKey();
                String value = (String)entry.getValue();
                propertiesParam.put(key,value);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getParam(String key){
        return propertiesParam.get(key);
    }


}

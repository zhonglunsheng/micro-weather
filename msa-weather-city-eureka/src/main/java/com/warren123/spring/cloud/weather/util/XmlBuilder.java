package com.warren123.spring.cloud.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * XmlBuilder class
 *
 * @author zhonglunsheng
 * @date 2018/7/2
 * @time 9:48
 */
public class XmlBuilder {
    /**
     * 将xml字符串转换为自定的对象
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr)throws Exception{
        Object xmlObject = null;

        Reader reader = null;

        JAXBContext context = JAXBContext.newInstance(clazz);

        //将xml 转为对象接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (null != reader){
            reader.close();
        }

        return xmlObject;
    }
}

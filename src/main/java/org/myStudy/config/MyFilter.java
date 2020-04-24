package org.myStudy.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyFilter implements TypeFilter {  /*继承TypeFilter接口*/

    /*实现match*/
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        String className = annotationMetadata.getClassName();
       // className.contains("StudentDaoSImpl");  失败
        if (className.contains("StudentDao"))   /*如果是StudentDao的实现类StudentDaoSImpl加入容器*/
            return true;
        if (className.contains("StudentController"))    /*如果是StudentDaoImpl加入容器  上面和这个两个都就爱如了*/
            return true;
        return false;
    }
}

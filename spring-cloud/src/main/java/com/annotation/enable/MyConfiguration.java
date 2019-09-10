package com.annotation.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liuruizhi
 * @since 2019/9/6
 */
public class MyConfiguration implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.annotation.enable.Role","com.annotation.enable.User"};
    }
}

package com.mrhuo.acore.util;

import com.mrhuo.acore.validator.IValidator;

/**
 * 验证器工具
 */
public class ValidatorUtil {
    /**
     * 使用指定的验证器验证
     *
     * @param validatorClass 验证器类型
     * @param data           需要验证的数据
     * @param <T>            任意的IValidator子类
     * @return
     */
    public static <T extends IValidator> boolean validate(Class<T> validatorClass, Object data) {
        try {
            T instance = validatorClass.newInstance();
            return instance.isPass(data);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
}

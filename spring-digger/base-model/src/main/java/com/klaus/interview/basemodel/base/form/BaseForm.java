package com.klaus.interview.basemodel.base.form;

import com.klaus.interview.basemodel.base.BasePo;
import com.klaus.interview.commonbase.error.SystemErrorType;
import com.klaus.interview.commonbase.exception.BaseException;
import org.springframework.beans.BeanUtils;

public class BaseForm <T extends BasePo> {

    /**
     * From转化为Po，进行后续业务处理
     *
     * @param clazz
     * @return
     */
    public T toPo(Class<T> clazz) throws BaseException {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (Exception e) {
            throw new BaseException(SystemErrorType.ARGUMENT_NOT_VALID, "params convert error", e.getCause());

        }
        BeanUtils.copyProperties(this, t);
        return t;
    }
}

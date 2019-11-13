package com.klaus.interview.basemodel.base;

import com.klaus.interview.basemodel.base.param.BaseParam;
import com.klaus.interview.commonbase.error.SystemErrorType;
import com.klaus.interview.commonbase.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class JpaBaseQueryForm<P extends BaseParam> extends JpaBaseForm {

    /**
     * Form转化为Param
     *
     * @param clazz
     * @return
     */
    public P toParam(Class<P> clazz) throws BaseException {
        P p = null;
        try {
            p = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BaseException(SystemErrorType.ARGUMENT_NOT_VALID, "params convert error", e.getCause());
        }
        BeanUtils.copyProperties(this, p);
        return p;
    }

}
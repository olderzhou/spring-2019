package com.klaus.interview.commonjpaconfig.po.form;

import com.klaus.interview.commonbase.error.SystemErrorType;
import com.klaus.interview.commonbase.exception.BaseException;
import com.klaus.interview.commonbase.po.param.BaseParam;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@ApiModel
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
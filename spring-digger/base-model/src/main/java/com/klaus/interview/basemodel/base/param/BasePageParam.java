package com.klaus.interview.basemodel.base.param;

import com.klaus.interview.commonbase.util.CommonConstants;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class BasePageParam extends AbstractPageRequest {
    public BasePageParam(int page, int size) {
        super(page, size);
    }
    public BasePageParam() {
        super(CommonConstants.PageDefault.START_PAGE.getValue(), CommonConstants.PageDefault.START_SIZE.getValue());
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previous() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }
}

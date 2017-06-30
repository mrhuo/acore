package com.mrhuo.acore.controller;

import com.mrhuo.acore.base.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected RestResult permissionDeniedResult() {
        return new RestResult(401, "PERMISSION DENIED");
    }

    protected RestResult<Object> okResult(Object data) {
        return new RestResult<Object>(200, "OK", data);
    }

    protected RestResult<Object> okResult() {
        return okResult(null);
    }

    protected RestResult errorResult(int code, String msg) {
        return new RestResult(code, msg);
    }
}

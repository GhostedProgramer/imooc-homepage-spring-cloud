package com.immoc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class PreRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //数值越小优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否启用过滤器
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //ctx用于在过滤器中传递信息,request和response信息也可以用它直接获取
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime", System.currentTimeMillis());
        return null;
    }
}

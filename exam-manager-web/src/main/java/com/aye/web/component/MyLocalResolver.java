package com.aye.web.component;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Aye
 * @version $Id: MyLocalResolver, v 0.1 2019/3/26 17:40 Aye Exp$
 * 国际化解析
 */


public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lg = httpServletRequest.getParameter("lg");
        Locale local = Locale.getDefault();
        if (!StringUtils.isEmpty(lg)){
            String [] split = lg.split("_");
            local= new Locale(split[0],split[1]);
        }
        return local;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

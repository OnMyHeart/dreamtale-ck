//package com.dreamtale.ck.config;
//
//import com.dreamtale.ck.interceptor.WebBaseInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @author  dream
// * Created by yingshuai on 2018/8/21.
// */
//@Configuration
//public class MyWebMvcConfigAdapter implements WebMvcConfigurer {
//
//    /**
//     * 配置静态资源
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//        addResourceHandlers(registry);
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //addPathPatterns 用于添加拦截规则
//        //excludePathPatterns 用于排除拦截
//        registry.addInterceptor(
//                new WebBaseInterceptor())
//                .addPathPatterns("/**")
//                //登录页
//                .excludePathPatterns("/admin/login.html")
//                //首页
//                .excludePathPatterns("/admin/index.html")
//
//                //仓库 - 订单列表页面
//                .excludePathPatterns("/admin/ck/order/list.html")
//                //仓库 - 订单查询接口
//                .excludePathPatterns("/admin/ck/order/queryOrderList")
//                //仓库 - 用户列表页面
//                .excludePathPatterns("/admin/ck/user/list.html")
//                //仓库 - 用户查询接口
//                .excludePathPatterns("/admin/ck/user/queryUserList")
//                //仓库 - 区域列表页面
//                .excludePathPatterns("/admin/ck/district/list.html")
//                //仓库 - 区域查询接口
//                .excludePathPatterns("/admin/ck/district/queryDistrictList")
//                //仓库 - 产品列表接口
//                .excludePathPatterns("/admin/ck/product/list.html")
//                //仓库 - 产品查询接口
//                .excludePathPatterns("/admin/ck/product/queryProductList")
//                .excludePathPatterns("/admin/ck/order/**")
//
//                //用户注册
//                .excludePathPatterns("/admin/register.html")
//                //用户登录
//                .excludePathPatterns("/admin/login");
//        addInterceptors(registry);
//    }
//
//}

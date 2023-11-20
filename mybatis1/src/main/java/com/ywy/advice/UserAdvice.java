package com.ywy.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 配置切面类
 *
 * @Aspect 告诉spring这是一个切面类
 * @Component 将切面类交给spring容器管理
 * 切点表达式: 匹配任意返回值 任意包下的任意参数的任意方法作为切点 execution(* *..*(..))
 */
@Aspect
@Component
public class UserAdvice {
    /**
     * 配置切点 通知可以直接引用
     */
    @Pointcut("execution(* com.ywy.dao.UserDao.findAll(..))")
    public void pointCut() {
    }

    /**
     * 配置前置通知
     * args: 定义参数名
     * argNames: 可以改变args的顺序 类型要一致
     */
//    @Before("pointCut()") // 引用切点
    @Before(value = "execution(* com.ywy.App.testAspectJ(..)) && args(name, age))", argNames = "name,age")
    void beforeMethod(String name, int age) {
        System.out.println("before方法执行了...");
    }

    /**
     * 配置后置通知
     */
    @After("execution(* com.ywy.dao.UserDao.*(..))")
    void afterMethod() {
        System.out.println("after方法执行了...");
    }

    /**
     * 配置返回后通知 原始方法执行完毕返回结果后执行 先于After执行
     * returning: 配置返回值名称
     */
    @AfterReturning(value = "execution(* com.ywy.App.testAspectJ(..))", returning = "ret")
    void afterReturningMethod(Object ret) {
        System.out.println("returning返回值:" + ret);
        System.out.println("afterReturning方法执行了...");
    }


    /**
     * 环绕通知 原始方法执行前后都会执行 先于Before执行后于After 非常强大 可以阻止方法执行
     * 异常直接catch即可获取到异常信息
     */
    @Around("execution(* com.ywy.App.testAspectJ(..))")
    Object aroundMethod(ProceedingJoinPoint pjp) {
        Object result = null;
        System.out.println("around方法before执行了");
        try {
            result = pjp.proceed(); // 调用原始方法
        } catch (Throwable t) {
            System.out.println("异常信息:" + t.getMessage());
        }
        Signature signature = pjp.getSignature(); // 获取签名
        String name = signature.getName(); // 获取方法名
        System.out.println("方法名: " + name);
        Arrays.stream(pjp.getArgs()).forEach(item -> {
            System.out.println("方法参数" + item);
        });
        System.out.println("around方法after执行了");
        return result; // 返回原始方法的返回值
    }

    /**
     * 抛出异常后通知 原始方法执行抛出异常后执行
     * throwing: 配置抛出的异常接收变量名
     */
    @AfterThrowing(value = "execution(* com.ywy.dao.UserDao.*(..))", throwing = "t")
    void afterThrowingMethod(Throwable t) {
        System.out.println("抛出的异常:" + t.getMessage());
        System.out.println("afterThrowing方法执行了,原始方法抛出了异常");
    }
}

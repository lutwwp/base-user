package com.wwp.demo.aop;

import com.wwp.demo.annotation.DecryptionAmount;
import com.wwp.demo.annotation.EncryptionAmount;
import com.wwp.demo.entity.User;
import com.wwp.demo.util.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName EncryptionAndDecryptionAmountAspect
 * @Description: TODO
 * @Author wwp
 * @Date 2019-10-31
 * @Version V1.0
 **/
@Aspect
@Component
@Slf4j
public class EncryptionAndDecryptionAmountAspect {

    @Pointcut("@annotation(com.wwp.demo.annotation.DecryptionAmount)")
    public void amountDecrypt() {
    }

    @Pointcut("@annotation(com.wwp.demo.annotation.EncryptionAmount)")
    public void amountEncrypt() {
    }
    /**
     * @MethodName: doBefore
     * @Description: 保存到数据库之前先加密
     * @Param: [joinPoint]
     * @Return: void
     * @Author: wwp
     * @Date: 2019-10-31
    **/
    @Before("amountEncrypt()")
    public void doBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            Method method = ((MethodSignature) signature).getMethod();
            //获取方法的所有注解
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                if (declaredAnnotation instanceof EncryptionAmount) {
                    Object[] args = joinPoint.getArgs();
                    for (Object arg : args) {
                        if (arg instanceof User) {
                            User user = (User) arg;
                            String amount = user.getAmount();
                            user.setAmount(AESUtil.aesEncode(amount));
                        }
                    }
                }
            }
        }
    }
    /**
     * @MethodName: doAfter
     * @Description: 查询返回数据之前解密
     * @Param: [joinPoint, resultValue]
     * @Return: void
     * @Author: wwp
     * @Date: 2019-10-31
    **/
    @AfterReturning(value = "amountDecrypt()", returning = "resultValue")
    public void doAfter(JoinPoint joinPoint, Object resultValue) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            Method method = ((MethodSignature) signature).getMethod();
            //获取方法的所有注解
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                if (declaredAnnotation instanceof DecryptionAmount) {
                    log.info(resultValue.toString());
                    if (resultValue instanceof List) {
                        List<User> userList = (List) resultValue;
                        for (User user : userList) {
                            if (!StringUtils.isEmpty(user.getAmount())) {
                                user.setAmount(AESUtil.aesDecode(user.getAmount()));
                            }
                        }
                    }
                }
            }
        }
    }
}

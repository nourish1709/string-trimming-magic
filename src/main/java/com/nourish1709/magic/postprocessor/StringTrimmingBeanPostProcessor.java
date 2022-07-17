package com.nourish1709.magic.postprocessor;

import com.nourish1709.magic.annotation.Trimmed;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class StringTrimmingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        final Class<?> beanType = bean.getClass();

        if (beanType.isAnnotationPresent(Trimmed.class)) {
            final Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
                for (int i = 0; i < objects.length; i++) {
                    if (objects[i].getClass().equals(String.class)) {
                        objects[i] = ((String) objects[i]).trim();
                    }
                }

                if (method.getReturnType().equals(String.class)) {
                    return ((String) methodProxy.invokeSuper(o, objects)).trim();
                }

                return methodProxy.invokeSuper(o, objects);
            });

            return enhancer.create();
        }

        return bean;
    }
}

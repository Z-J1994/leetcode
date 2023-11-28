package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangjun
 * @since 2023/11/28 14:08
 */
public class Invoker {

    public static <T> T[] invoke(Class<?> target, Object[] args, T[] results, String[] methodNames) {
        Map<String, Method> methodMap = Arrays.stream(target.getDeclaredMethods()).collect(Collectors.toMap(Method::getName, m -> m));
        Constructor<?> constructor = target.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        int i = 0;
        try {
            Object instance;
            Class<?> enclosingClass = target.getEnclosingClass();
            if (enclosingClass != null) {
                Constructor<?> enclosingClassConstructor = enclosingClass.getDeclaredConstructors()[0];
                enclosingClassConstructor.setAccessible(true);
                Object outer = enclosingClassConstructor.newInstance();
                instance = constructor.newInstance(outer);
            } else {
                instance = constructor.newInstance();
            }
            for (i = 1; i < methodNames.length; i++) {
                Method method = methodMap.get(methodNames[i]);
                method.setAccessible(true);
                if (method.getReturnType() == Void.TYPE) {
                    invoke(instance, method, args[i]);
                    continue;
                }
                results[i] = (T) invoke(instance,method, args[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("exception occur when i = " + i,e);
        }
        return results;
    }

    private static Object invoke(Object instance, Method method, Object args) throws Exception{
        if(method.getParameterCount() > 0){
            return method.invoke(instance,  args);
        }
        return method.invoke(instance);
    }
}



package com.briatka.pavol.themilkyway;

import com.briatka.pavol.themilkyway.models.customobjects.NasaObject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@RunWith(JUnit4.class)
public class NasaObjectTest {

    @Test
    public void public_constructors_exist() {
        Constructor[] constructors = NasaObject.class.getConstructors();
        Assert.assertEquals(1,constructors.length);
        for (Constructor constructor: constructors) {
            Assert.assertTrue("All constructors should be public", Modifier.isPublic(constructor.getModifiers()));
        }
    }

    @Test
    public void first_constructor_string_params_only() {
        Constructor[] constructors = NasaObject.class.getConstructors();
        Constructor firstConstructor = constructors[0];
        Class<?>[] paramTypes = firstConstructor.getParameterTypes();
        for(Class<?> paramType: paramTypes) {
            String type = paramType.getSimpleName();
            Assert.assertTrue("All parameters should be String",type.equals("String"));
        }
    }

    @Test
    public void method_count() {
        Method[] methods = NasaObject.class.getDeclaredMethods();
        Assert.assertEquals(12, methods.length);
    }
}

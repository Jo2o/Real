package reflections;

import java.lang.reflect.Method;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
            Class<MyStatic> myStaticClass = MyStatic.class;
            Method getDpiXMethod = myStaticClass.getMethod("getDpiX");
            getDpiXMethod.setAccessible(true);
            System.out.println(MyStatic.needScaling());

//        System.out.println("-------- JAVASSIST ----------");
//
//        ClassPool classPool = ClassPool.getDefault();
//        CtClass myStaticClass = classPool.get("reflections.MyStatic");
//        CtMethod getDpiXMethod = myStaticClass.getDeclaredMethod("getDpiX");
//        getDpiXMethod.setBody("{ return 5; }");
//        myStaticClass.writeFile();
//        myStaticClass.detach();
//
//        System.out.println(MyStatic.needScaling());
    }
}

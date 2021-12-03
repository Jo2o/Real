package j.packt.Chapter07.P164_InspectPackagesInModules.org.player.classes.com.members;

import java.packt.Chapter07.P164_InspectPackagesInModules.src.org.tournament.classes.com.management.Manager;

import java.util.Set;

public class Main {
    
    public static void main(String[] args) {
        Manager mgt = new Manager();
        
        Set<String> packages = mgt.getClass().getModule().getPackages();
        System.out.println("Packages: " + packages);
        
        Class<?> clazz = Class.forName(mgt.getClass().getModule(), "com.management.Manager");
        System.out.println("Clazz: " + clazz);          
    }
}

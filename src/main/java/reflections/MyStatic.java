package reflections;

public class MyStatic {

    public static boolean needScaling() {
        return getDpiX() == 96 ;
    }

//    public static boolean needScaling(boolean forDisplay) {
//        return getDpiX(forDisplay) != 96 || getDpiY(forDisplay) != 96;
//    }

    private static int getDpiX() {
        System.out.println("inside getDpiX");
        return 96;
    }

}

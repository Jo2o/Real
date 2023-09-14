package designpatterns.singleton;

public enum SingletonEagerEnum {
    INSTANCE("S-1");

    private String value;

    SingletonEagerEnum(String value) {
        this.value = value;
    }

    public void doSomething() {
        System.out.println(value);
    }
}

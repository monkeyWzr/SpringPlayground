package playground.rsocket.channel;

public class TestBean {
    private String name;

    public TestBean() {}
    private TestBean(String name) {
        this.name = name;
    }

    public static TestBean of(String name) {
        return new TestBean(name);
    }

    public static void main() {
        TestBean b = new TestBean("");
    }

}

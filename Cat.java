package com.lous;

@MyAnnotation(name="yiiyi",like = {"金鱼","鲤鱼","草鱼"},color1 = Color1.BLUE)
public class Cat {
    private String name;
    private String age;
    private Color1 color1;

    public Color1 getColor1() {
        return color1;
    }

    public void setColor1(Color1 color1) {
        this.color1 = color1;
    }

    public Cat() {
    }

    public Cat(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //用于验证方法是否为覆盖父类中的方法
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    //用于标记方法已过时,不建议使用
    @Deprecated
    public String printInfo() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}

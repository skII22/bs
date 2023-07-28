package vueshop.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
public enum EnumCategory {
    手机(1),
    电视机(2),
    空调(3),
    洗衣机(4),
    保护套(5),
    保护膜(6),
    充电器(7),
    充电宝(8);

    private final int value;
    EnumCategory(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "EnumCategory{" +
                "value=" + value +
                '}';
    }
    public static EnumCategory fromValue(int value) {
        for (EnumCategory category : values()) {
            if (category.getValue() == value) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid EnumCategory value: " + value);
    }
    //用于指定一个自定义的反序列化方法
//    @JsonCreator 注解用于指定一个自定义的反序列化方法，方法的参数类型为整数类型，返回值类型为枚举类型
//    EnumCategory。fromJson 方法内部调用了 fromValue 方法来将整数值转化为枚举类型。注意要导入 Jackson 的 @JsonCreator 注解。
//    使用这种方式定义枚举类型后，Jackson 就能够正确地将接收到的 JSON 中的整数值转化为枚举类型了。
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EnumCategory fromJson(int value) {
        return fromValue(value);
    }

}

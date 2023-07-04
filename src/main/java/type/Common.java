package type;

/**
 * 常见题
 *
 * @author Ivan
 * @since 2023/2/28
 */
public interface Common {
    /**
     * 字符串处理
     */
    interface Str extends Common {
    }

    /**
     * 数字处理
     * 包含位运算、数学方法、模拟、逻辑运算符等
     */
    interface Number extends Common {
    }

    /**
     * hash有关
     */
    interface Hash extends Common {
    }

    /**
     * 暴力
     */
    interface Violent extends Common {
    }
}

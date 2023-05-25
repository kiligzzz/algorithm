package type;

/**
 * 常见题
 *
 * @author Ivan
 * @date 2023/2/28 15:27
 */
public interface Common {
    /**
     * 字符串处理
     */
    interface Str extends Common {
    }

    /**
     * 数字处理
     * 包含位运算等
     */
    interface Number extends Common {
    }

    /**
     * hash有关
     */
    interface Hash extends Common {
    }
}

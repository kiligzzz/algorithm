package type;

/**
 * 常见方法
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
     */
    interface Number extends Common {
    }

    /**
     * hash有关
     */
    interface Hash extends Common {
    }
}

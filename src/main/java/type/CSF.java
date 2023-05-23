package type;

/**
 * 组合（combination）、子集（subset）、全排列（fullPermutation）
 *
 * @author Ivan
 * @date 2023/4/24 18:29
 */
public interface CSF {
    /**
     * 组合
     */
    interface Combination extends CSF {
    }

    /**
     * 子集
     */
    interface Subset extends CSF {
    }

    /**
     * 全排列
     */
    interface FullPermutation extends CSF {
    }
}

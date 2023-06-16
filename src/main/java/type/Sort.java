package type;

import support.BasicUtil;

/**
 * 排序
 *
 * @author Ivan
 * @since 2023/6/16
 */
public interface Sort {
    /**
     * 快排（TopK问题）{@link BasicUtil#quickSort(int[])}
     */
    interface QuickSort extends Sort {
    }
}

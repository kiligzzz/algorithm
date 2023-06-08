package type;

/**
 * 数据结构
 *
 * @author Ivan
 * @since 2023/2/28
 */
public interface DataStructure {
    /**
     * 数组
     */
    interface Arrayed extends DataStructure {
    }

    /**
     * 矩阵
     */
    interface Matrix extends DataStructure {
    }

    /**
     * 链表
     */
    interface Linked extends DataStructure {
    }

    /**
     * 栈
     */
    interface Stacked extends DataStructure {
    }

    /**
     * 队列
     */
    interface Queued extends DataStructure {
    }

    /**
     * 二叉树
     */
    interface BinaryTree extends DataStructure {
        /**
         * 二叉查找树
         * 定义：左(右)子树上所有结点的值均小(大)于它的根结点的值
         */
        interface BinarySearchTree extends BinaryTree {
        }
    }
}

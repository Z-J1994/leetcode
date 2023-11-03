package tree;

public interface ITreeNode {

    int getVal();

    void setVal(int value);

    ITreeNode getLeft();

    void setLeft(ITreeNode node);

    ITreeNode getRight();

    void setRight(ITreeNode node);
}

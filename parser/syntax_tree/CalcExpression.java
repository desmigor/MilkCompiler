package syntax_tree;

public class CalcExpression implements IExpression {
    private IExpression left;
    private IExpression right;
    private String op;

    public IExpression getLeft() {
        return left;
    }

    public void setLeft(IExpression left) {
        this.left = left;
    }

    public IExpression getRight() {
        return right;
    }

    public void setRight(IExpression right) {
        this.right = right;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public CalcExpression(Object left, Object right, Object op) {
        this.left = (IExpression) left;
        this.right = (IExpression) right;
        this.op = (String) op;
    }

    @Override
    public String toString(int indent) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < indent; ++i) {
            res.append('\t');
        }
        res.append(this);
        return res.toString();
    }

    @Override
    public String toString() {
        return left.toString() + ' ' + op + ' ' + right.toString();
    }
}

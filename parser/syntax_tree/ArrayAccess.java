package syntax_tree;

public class ArrayAccess implements IExpression {
    private IExpression arrayExpression;
    private IExpression arrayEnumerator;

    public IExpression getArrayExpression() {
        return arrayExpression;
    }

    public void setArrayExpression(IExpression arrayExpression) {
        this.arrayExpression = arrayExpression;
    }

    public IExpression getArrayEnumerator() {
        return arrayEnumerator;
    }

    public void setArrayEnumerator(IExpression arrayEnumerator) {
        this.arrayEnumerator = arrayEnumerator;
    }

    public ArrayAccess(Object array, Object enumerator) {
        this.arrayExpression = (IExpression) array;
        this.arrayEnumerator = (IExpression) enumerator;
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
        return arrayExpression.toString() + "[" + arrayEnumerator.toString() + "]";
    }
}

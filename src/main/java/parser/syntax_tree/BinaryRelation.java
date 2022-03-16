package parser.syntax_tree;

import interpreter.ExecutionContext;

import java.util.Objects;

public class BinaryRelation implements IRelation {
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

    public BinaryRelation(Object left, Object right, Object op) {
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

    @Override
    public IValue execute(ExecutionContext context) {
        IValue left = getLeft().execute(context);
        IValue right = getRight().execute(context);

        if (left instanceof BooleanValue && right instanceof BooleanValue) {
            if (Objects.equals(op, RelationOp.AND)) {
                return new BooleanValue(String.valueOf(((BooleanValue) left).getValue() && ((BooleanValue) right).getValue()));
            } else if (Objects.equals(op, RelationOp.OR)) {
                return new BooleanValue(String.valueOf(((BooleanValue) left).getValue() || ((BooleanValue) right).getValue()));
            } else if (Objects.equals(op, RelationOp.XOR)) {
                return new BooleanValue(String.valueOf(((BooleanValue) left).getValue() ^ ((BooleanValue) right).getValue()));
            } else {
                throw new RuntimeException("Operation " + op + " cannot be applied to " + left.getClass().getName() + " and " + right.getClass().getName());
            }
        } else if (left instanceof IntegerValue && right instanceof IntegerValue) {
            if (Objects.equals(op, RelationOp.GT)) {
                return new BooleanValue(String.valueOf(((IntegerValue) left).getValue() > ((IntegerValue) right).getValue()));
            } else if (Objects.equals(op, RelationOp.LT)) {
                return new BooleanValue(String.valueOf(((IntegerValue) left).getValue() < ((IntegerValue) right).getValue()));
            } else if (Objects.equals(op, RelationOp.EQ)) {
                return new BooleanValue(String.valueOf(((IntegerValue) left).getValue() == ((IntegerValue) right).getValue()));
            } else if (Objects.equals(op, RelationOp.GTEQ)) {
                return new BooleanValue(String.valueOf(((IntegerValue) left).getValue() >= ((IntegerValue) right).getValue()));
            } else if (Objects.equals(op, RelationOp.LTEQ)) {
                return new BooleanValue(String.valueOf(((IntegerValue) left).getValue() <= ((IntegerValue) right).getValue()));
            } else {
                throw new RuntimeException("Operation " + op + " cannot be applied to " + left.getClass().getName() + " and " + right.getClass().getName());
            }
        } else {
            throw new RuntimeException("Operation " + op + " cannot be applied to " + left.getClass().getName() + " and " + right.getClass().getName());
        }
    }
}

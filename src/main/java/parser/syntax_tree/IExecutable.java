package parser.syntax_tree;

import interpreter.ExecutionContext;

public interface IExecutable {
    IValue execute(ExecutionContext context);
}

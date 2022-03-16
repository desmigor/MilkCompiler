package interpreter;

import parser.syntax_tree.Program;

public class TreeInterpreter {

    private final Program _program;
    private final ExecutionContext _context = new ExecutionContext();

    public TreeInterpreter(Program program) {
        _program = program;
    }

    public void execute() {
        _program.execute(_context);
    }

}

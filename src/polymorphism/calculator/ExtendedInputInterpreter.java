package polymorphism.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExtendedInputInterpreter extends InputInterpreter{
    private final Deque<Integer> memory;
    public ExtendedInputInterpreter(CalculationEngine engine) {
        super(engine);
        this.memory = new ArrayDeque<>();
    }

    @Override
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }

        if (operation.equals("/")) {
            return new DivisionOperation();
        }

        if (operation.equals("ms")) {
            return new MemorySaveOperation(this.memory);
        }

        if (operation.equals("mr")) {
            return new MemoryRecallOperation(this.memory);
        }

        return null;
    }
}

package polymorphism.calculator;

import java.util.Deque;

public class MemorySaveOperation implements Operation {
    private final Deque<Integer> memory;
    private boolean receivedOperand;

    public MemorySaveOperation(Deque<Integer> memory) {
        this.memory = memory;
        this.receivedOperand = false;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);

        this.receivedOperand = true;
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return this.receivedOperand;
    }
}

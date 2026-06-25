package DSA.structures;

import DSA.models.Patient;

import java.util.Stack;

public class StackManager {

    // =====================================================
    // Undo Stack
    // =====================================================

    private final Stack<Patient> undoStack;

    // =====================================================
    // Constructor
    // =====================================================

    public StackManager() {
        undoStack = new Stack<>();
    }

    // =====================================================
    // Push Operation
    // =====================================================

    public void push(Patient patient) {

        if (patient != null) {
            undoStack.push(patient);
        }

    }

    // =====================================================
    // Undo Operation
    // =====================================================

    public Patient pop() {

        if (undoStack.isEmpty()) {
            return null;
        }

        return undoStack.pop();
    }

    // =====================================================
    // View Last Operation
    // =====================================================

    public Patient peek() {

        if (undoStack.isEmpty()) {
            return null;
        }

        return undoStack.peek();
    }

    // =====================================================
    // Stack Status
    // =====================================================

    public boolean isEmpty() {
        return undoStack.isEmpty();
    }

    public int size() {
        return undoStack.size();
    }

    // =====================================================
    // Clear Stack
    // =====================================================

    public void clear() {
        undoStack.clear();
    }

}
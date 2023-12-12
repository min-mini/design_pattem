package myTest.behavioralPatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MeInterpreter {
    public static void main(String[] args) {
        // Context
        Map<String, Integer> context = new HashMap<>();
        context.put("x", 5);
        context.put("y", 10);

        // Expression: x + (y - 5)
        String expression = "x + y - 5";
        Evaluator evaluator = new Evaluator(expression);

        // Evaluate the expression
        int result = evaluator.evaluate(context);
        System.out.println("Result: " + result); // Output: 10
    }
}

// AbstractExpression
interface Expression {
    int interpret(Map<String, Integer> context);
}

// TerminalExpression
class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return number;
    }
}

// NonterminalExpression
class Plus implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public Plus(Expression left, Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return leftOperand.interpret(context) + rightOperand.interpret(context);
    }
}

// NonterminalExpression
class Minus implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public Minus(Expression left, Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return leftOperand.interpret(context) - rightOperand.interpret(context);
    }
}

// Context
class Evaluator {
    private Expression syntaxTree;

    public Evaluator(String expression) {
        Stack<Expression> expressionStack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                if (!expressionStack.isEmpty()) { // 스택이 비어있지 않을 때만 pop
                    Expression left = expressionStack.pop();
                    Expression right = new Number(Integer.parseInt(tokens[++i]));
                    expressionStack.push(new Plus(left, right));
                }
            } else if (tokens[i].equals("-")) {
                if (!expressionStack.isEmpty()) { // 스택이 비어있지 않을 때만 pop
                    Expression left = expressionStack.pop();
                    Expression right = new Number(Integer.parseInt(tokens[++i]));
                    expressionStack.push(new Minus(left, right));
                }
            } else {
                try {
                    int operand = Integer.parseInt(tokens[i]);
                    expressionStack.push(new Number(operand));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid token: " + tokens[i]);
                }
            }
        }

        if (!expressionStack.isEmpty()) {
            syntaxTree = expressionStack.pop();
        } else {
            System.err.println("Expression is empty.");
        }
    }

    public int evaluate(Map<String, Integer> context) {
        if (syntaxTree != null) {
            return syntaxTree.interpret(context);
        } else {
            System.err.println("Syntax tree is null. Cannot evaluate.");
            return 0;
        }
    }
}
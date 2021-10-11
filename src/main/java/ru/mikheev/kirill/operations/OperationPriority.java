package ru.mikheev.kirill.operations;

public enum OperationPriority {
    SUM_PRIORITY(1),
    MULTIPLICATION_PRIORITY(2),
    POW_PRIORITY(3),
    BRACKETS_PRIORITY(4),
    TOKEN_PRIORITY(5);

    private int priorityValue;

    OperationPriority(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public static OperationPriority getPriorityBySign(String sign) {
        switch (sign) {
            case "+" :
            case "-" : return SUM_PRIORITY;
            case "*" :
            case "/" : return MULTIPLICATION_PRIORITY;
            default: throw new RuntimeException("Операция не поддерживается");
        }
    }
}

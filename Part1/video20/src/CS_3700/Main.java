package CS_3700;

public class Main {
    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println("Value of i is " + i);
            System.out.println(this);
        });
    }

    public static void main(String[] args) {
        Main thisReferenceExample = new Main();
        thisReferenceExample.execute();
    }

    public String toString() {
        return "This is the main ThisReferenceExample class instance";
    }
}

interface Process {
    void process (int i);
}
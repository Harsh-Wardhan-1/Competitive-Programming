public class solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int val = 0;
        ArrayList<String> l = new ArrayList<>(List.of("+", "-", "/", "*"));
        for (int i = 0; i < tokens.length; i++) {
            String st = tokens[i];
            if (l.contains(st)) {
                int a = s.pop();
                int b = s.pop();
                switch (st) {
                    case "+":
                        val = b + a;
                        break;
                    case "-":
                        val = b - a;
                        break;
                    case "*":
                        val = b * a;
                        break;
                    case "/":
                        val = b / a;
                        break;
                }
                s.push(val);
            } else {
                s.push(Integer.parseInt(st));
            }
        }
        return s.pop();
    }
}

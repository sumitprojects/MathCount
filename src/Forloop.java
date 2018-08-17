public class Forloop {
    public static void main (String[] args) {
        char name[] = {'l', 'k', 'j', 'i'};
        forloops(0, 2, 1, name, 1, 1);
    }
    
    private static void forloops (int low, int end, int loops, char name[], int inc, int count) {
        int i;
        if (count <= 1) {
            loops(low, end, loops, name, inc, count, low, end);
        } else if (count < loops) {
            loops(low, end, loops, name, inc, count, low, end);
        } else if (count == loops) {
            if (inc == 1) {
                for (i = low; i < end; i++) {
                    System.out.println("\tinc " + name[count - 1] + "=" + i + " loops = " + count + "\t\n");
                }
                --count;
            } else {
                for (i = end - 1; i >= low; i--) {
                    System.out.println("\tdec " + name[count - 1] + "=" + i + " loops = " + count + "\t\n");
                }
                --count;
            }
        }
    }
    
    private static void loops (int low, int end, int loops, char[] name, int inc, int count, int l, int e) {
        int i;
        if (inc == 1) {
            for (i = low; i < end; i++) {
                System.out.println("\tinc " + name[count - 1] + "=" + i + " loops = " + count + "\t\n");
                forloops(l, e, loops, name, inc, count + 1);
            }
            //  loops = 0;
        } else {
            for (i = end - 1; i >= low; i--) {
                System.out.println("\tdec " + name[count - 1] + "=" + i + " loops = " + count + "\t\n");
                forloops(l, e, loops, name, inc, count + 1);
            }
        }
    }
}

package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int M=10000;
        Integer [] l={1000,2000,4000,8000,16000,32000,64000,128000};
        AList<Integer> Ns=new AList<>();
        AList<Integer> op=new AList<>();
        for(int i=0;i<l.length;i++)
        {
            Ns.addLast(l[i]);
            op.addLast(M);
        }
        AList<Double> time=new AList<>();
        for(int i=0;i<l.length;i++)
        {
            SLList<Integer> s=new SLList<>();
            for(int j=0;j<l[i];j++)
            {
                s.addLast(0);
            }
            Stopwatch sw=new Stopwatch();
            for(int j=0;j<M;j++)
            {
                s.getLast();
            }
            double tim= sw.elapsedTime();
            time.addLast(tim);
        }
        printTimingTable(Ns,time,op);
    }

}

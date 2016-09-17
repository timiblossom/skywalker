class Fibonacci {
   public static void main(String[] args)  {
       if (args.length != 1) {
           System.out.println("Usage Fibonacci number");
           System.exit(1);
       }

       int n = Integer.parseInt(args[0]);           
       System.out.println("Fibo at n=" + n + " is " + computeFiboNumber(n));
   }

   private static long computeFiboNumber(int n) {
        long fiboNMinusOne = 0, fiboNMinusTwo = 1;
        long result = 0;
        
        if (n == 0)
           return 0;
        if (n == 1)
           return 1;        

        for (int i=2; i<=n; i++) {
            result = fiboNMinusOne + fiboNMinusTwo;
            fiboNMinusTwo = fiboNMinusOne;
            fiboNMinusOne = result;
        }

        return result;
   }
}

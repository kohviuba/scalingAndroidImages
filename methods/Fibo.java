public class Fibo {

        public static void main(String[] args) {
                long startTime = System.nanoTime( );
                //number of elements to generate in a series
                int limit = 200000;

                long[] series = new long[limit];

                //create first 2 series elements
                series[0] = 0;
                series[1] = 1;

                //create the Fibonacci series and store it in an array
                for(int i=2; i < limit; i++){
                        series[i] = series[i-1] + series[i-2];
                }

                //print the Fibonacci series numbers
               /*
                System.out.println("Fibonacci Series upto " + limit);
                for(int i=0; i< limit; i++){
                        System.out.print(series[i] + " ");
                }
*/
                System.out.println((System.nanoTime() - startTime)*1.0e-6);
        }
}


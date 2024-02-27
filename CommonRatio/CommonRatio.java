import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
public class CommonRatio
{
    public static boolean hasCommonRatio(ArrayList<Double> geometricSeries)
    {
        ArrayList<Double> ratios = new ArrayList<>(geometricSeries.size() - 1);

        for(int i = 1; i < geometricSeries.size(); i++)
        {
            ratios.add(geometricSeries.get(i)/geometricSeries.get(i - 1));
        }

        Double commonRatio = ratios.getFirst();
        for(Double ratio : ratios)
        {
            if(!Objects.equals(ratio, commonRatio)) return false;
        }
        return true;
    }

    public static double getCommonRatio(ArrayList<Double> geometricSeries)
    {
        return (double) geometricSeries.get(1) /geometricSeries.getFirst();
    }

    public static void main(String[] args)
    {
        System.out.println("Enter the number of terms to enter in your geometric series (at least 2): ");
        Scanner scanner = new Scanner(System.in);
        int numberOfTerms = scanner.nextInt();
        System.out.println();

        ArrayList<Double> geometricSeries = new ArrayList<>(numberOfTerms);
        for(int i = 0; i < numberOfTerms; i++)
        {
            System.out.println("Enter term #" + (i + 1) + ": ");
            Double term = scanner.nextDouble();
            geometricSeries.add(i, term);
        }

        System.out.println();
        if(hasCommonRatio(geometricSeries))
        {
            System.out.println("Your geometric series has a common ratio of: " + getCommonRatio(geometricSeries));
        }
        else
        {
            System.out.println("Your series is not geometric.");
        }
    }

}

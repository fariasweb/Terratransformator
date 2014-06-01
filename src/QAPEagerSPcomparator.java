import java.util.Comparator;

public class QAPEagerSPcomparator implements Comparator<QAPEagerSP>
{
    @Override
    public int compare(QAPEagerSP  x, QAPEagerSP  y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        
    	return (int)(-(y.min-x.min));
    	/*if (x.min < y.min)
        {
            return 1;
        }
        if (x.min > y.min)
        {
            return -1;
        }
        return 0;*/
    }
}
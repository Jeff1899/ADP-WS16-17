/**
 * Created by patricklanger on 09.12.16.
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        computeLevenshteinDistance("patrick", "jeffrey");
    }

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(CharSequence ist, CharSequence soll) {
        int[][] distance = new int[ist.length() + 1][soll.length() + 1];

        for (int i = 0; i <= ist.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= soll.length(); j++)
            distance[0][j] = j;

        for (int i = 1; i <= ist.length(); i++)
            for (int j = 1; j <= soll.length(); j++)
                distance[i][j] = minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((ist.charAt(i - 1) == soll.charAt(j - 1)) ? 0 : 1));

        System.out.println(distance[ist.length()][soll.length()]);
        return distance[ist.length()][soll.length()];
    }
}

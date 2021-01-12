package Problems;

public class KnightsTour {
    static int N = 8;

    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static void printer(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int i1 = 0; i1 < N; i1++) {
                System.out.print(sol[i][i1] + " ");
            }
            System.out.println();
        }
    }

    static boolean solveKT() {
        int sol[][] = new int[8][8];
        for (int i = 0; i < N; i++) {
            for (int i1 = 0; i1 < N; i1++) {
                sol[i][i1] = -1;
            }
        }
        int x[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int y[] = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, sol, x, y)) {
            System.out.println("Solution not Exist");
            return false;
        } else {
            printer(sol);
            return true;
        }
    }

    static boolean solveKTUtil(int a, int b, int movei, int sol[][], int[] x, int[] y) {
        int k, next_x, next_y;
        if (movei == N * N) {
            return true;
        }
        for (k = 0; k < 8; k++) {
            next_x = a + x[k];
            next_y = b + y[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, x, y)) {
                    return true;
                }
                else {
                    sol[next_x][next_y] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveKT();
    }
}

class permutations
{
    static final int MAXCANDIDATES = 100;
    static final int NMAX = 100;
    static void backtrack(int a[], int k, int input)
    {
        int c[] = new int [MAXCANDIDATES];
        int ncandidates, i;
        if (k == input)
            process_solution(a,k);
        else
        {
            k++;
            ncandidates = construct_candidates(a,k,input,c);
            for (i=0; i<ncandidates; i++) {
                a[k] = c[i];
                backtrack(a,k,input);
            }
        }
    }
    static void process_solution(int a[],int k)
    {
        for(int i=1;i<=k;i++)
            System.out.printf(" %d",a[i]);
        System.out.printf("\n");
    }
    static int construct_candidates(int a[],int k,int n, int c[])
    {
        boolean in_perm[] = new boolean[NMAX];
        for(int i=1;i<k;i++)
            in_perm[a[i]] = true;
        int ncandidates = 0;
        for(int i=1;i<=n;i++)
            if(!in_perm[i])
            {
                c[ncandidates] = i;
                ncandidates++;
            }
        return ncandidates;
    }
    static public void main(String[] args)
    {
        int a[] = new int[NMAX];
        backtrack(a,0,3);
    }
}
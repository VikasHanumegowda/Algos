class isNumber
{
    public static void main(String [] args)
    {
        String s = ".3.4";
        char[] cArray = s.toCharArray();
        boolean dot = false;
        if(cArray[0] != '-' && (cArray[0] < '0' || cArray[0] > '9') && cArray[0] != '.') {
            System.out.println("Not a number");
            return;
        }
        if(cArray[0] == '.')
            dot = true;
        for(int i = 1; i < cArray.length; i++){
            if((cArray[i] < '0' || cArray[i] > '9') && (cArray[i] == '.' && dot)){
                System.out.println("Not a number");
                return;
            }
            if(cArray[i] == '.')
                dot = true;
        }
        System.out.println("Number");
    }
}
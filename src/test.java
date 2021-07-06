public class test {

    public static void main(String[] args) {
        String str = "012-3456-78-9-abc-defghi";
        String [] tokens = str.split("-");
        for (int i = 0; i<tokens.length; i++){
            System.out.print(tokens[i]+" ");
        }
    }
}

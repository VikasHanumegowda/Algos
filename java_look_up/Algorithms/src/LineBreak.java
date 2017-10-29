/**
 * Created by sridharyadav on 1/27/16.
 */
public class LineBreak {
    public static void main(String args[]){
        String sentence = "Meghana is a complicated woman";
        String word = "woman";
        String split[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < split.length; i++){
            if(!split[i].equals(word)){
                sb.append(split[i]);
                sb.append(' ');
            }
            else{
                sb.append("<br>");
                sb.append(split[i]);
                sb.append("</br>");
                sb.append(' ');
            }
        }
        System.out.println(sb.toString());
    }
}

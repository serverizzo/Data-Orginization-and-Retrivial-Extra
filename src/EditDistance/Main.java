package EditDistance;

public class Main {

    public static void main(String[] args){

        EditDistance obj = new EditDistance();

        if (args.length == 0){
            System.out.println("No arguments passed. Input will be 'dblha' and 'abch'");
            System.out.println(obj.calculateDistance("dblha", "abch"));
        }
        else if(args.length == 2){
            System.out.println(obj.calculateDistance(args[0], args[1]));
        }
    }
}

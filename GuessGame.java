import java.util.*;
import java.util.Random;

 class Game{
    int sysinput,userinput,noofguess=0;
    Game()
    {
        Random rand = new Random();
        this.sysinput = rand.nextInt(50)+1;
    }
    public boolean takeuserinput()
    {
        if(noofguess < 10)
        {
            System.out.println("Guess The Number:");
            this.userinput = GuessGame.takeIntegerInput(50);
            noofguess++;
            return false;
        }
        else{
            System.out.println("Soory! Number Of Attempts Finished...Better Try Next Time..");
            return true;
        }
    }
    public boolean Iscorrectguess()
    {
        if(sysinput == userinput)
        {
            System.out.println("Congratulations! You Guess The Number "+sysinput+" In "+noofguess+" Guesses");
            switch(noofguess)
            {
                case 1: System.out.println("You Scored 10"); break;
                case 2: System.out.println("You Scored 9"); break;
                case 3: System.out.println("You Scored 8");  break;
                case 4: System.out.println("You Scored 7"); break;
                case 5: System.out.println("You Scored 6"); break;
                case 6: System.out.println("You Scored 5"); break;
                case 7: System.out.println("You Scored 4"); break;
                case 8: System.out.println("You Scored 3"); break;
                case 9: System.out.println("You Scored 2"); break;
                case 10: System.out.println("You Scored 1"); break;
            }
            System.out.println();
            return true;
        }
        else if(noofguess < 10 && userinput > sysinput)
        {
            if(userinput - sysinput > 10)
            {
                System.out.println("Too High");
            }
            else
            {
                System.out.println("Little High");
            }
        }
        else if( noofguess < 10 && userinput < sysinput)
        {
            if( sysinput - userinput > 10)
            {
                System.out.println("Too Low");
            }
            else
            System.out.println("Little Low");
        }
        return false;
    }
}
class GuessGame{
    public static int takeIntegerInput(int limit)
    {
        int input = 0;
        boolean flag = false;
        while(!flag)
        {
            try{
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if(flag && input > limit || input < 1)
                {
                    System.out.println("Choose The Number Between 1 and "+limit);
                    flag = false;

                }
            }
            catch(Exception e)
            {
                System.out.println("Enter only Interger Values:");
                flag = false;
            }
        };
        return input;
    }

    public static void main(String[] args)
    {
        System.out.println("1.Start The Game   2.Exit");
        System.out.println("Enter Your Choice:");
        int choice = takeIntegerInput(2);
        int nextround = 1;
        int noofround = 0;
        if(choice == 1)
        {
            while(nextround == 1)
            {
                Game game = new Game();
                boolean ismatched = false;
                boolean islimitcross = false;
                System.out.println("Round "+ ++noofround+" Strats...");

                while(!ismatched && !islimitcross)
                {
                    islimitcross = game.takeuserinput();
                    ismatched = game.Iscorrectguess();
                }
                System.out.println("1. Next Round   2.Exit");
                System.out.println("Enter your choice:");
                nextround = takeIntegerInput(2);
                if(nextround != 1)
                {
                    System.exit(0);
                }
            }
        }
        else
        System.exit(0);
    }
   
}

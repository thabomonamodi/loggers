import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class PasswordChecker
{
    private static final Logger log = LogManager.getLogger(PasswordChecker.class.getName());

    public static boolean password_is_valid(String password)
    {
        boolean check = true;
        try
        {
            if (password.length()<8)
            {
                //System.out.println("password length should be 8 characters long.");
                log.error("password length should be 8 characters long.");
                check=false;
            }

            if (password.isEmpty())
            {
                log.error("password cannot be empty.");
                check=false;
            }

            if (!password.matches("(.*[a-z].*)"))
            {
                log.error("password should contain lowercase.");
                check=false;
            }
            if (!password.matches("(.*[A-Z].*)"))
            {
                System.out.println("password should contain uppercase.");
                check=false;
            }

            if (!password.matches("(.*[@#$%!].*)"))
            {
                System.out.println("password should have at least one special case.");
                check=false;
            }
            if(!password.matches("(.*[0-9].*)"))
            {
                System.out.println("password should have at least one digit.");
                check=false;
            }
        }
        catch (Exception e)
        {
            log.warn("make sure the above conditions are met."+e.getMessage());
        }
        return check;
    }
    public static boolean passwordIsOk(String password)throws Exception
    {
        //noinspection SingleStatementInBlock
        if ((password.length() < 8) || !password.matches("(.*[a-z].*)"))
        {
            log.error("gd");
            throw new Exception("Password should meet at least 3 of the conditions.\n"+
                    "1. Password length should be 8 characters long.\n"+
                    "2. Password cannot be empty.\n"+
                    "3. Password should contain lowercase.");
            //System.out.println();
            //return false;
        }
        if (!password.matches("(.*[A-Z].*)")|| !password.matches("(.*[@#$%!].*)") || !password.matches("(.*[0-9].*)"))
        {
            log.error("ba");
            throw new Exception("Password should meet at least 3 of the conditions:\n"+
                    "1. Password should contain uppercase.\n"+
                    "2. Password should have at least one special case.\n"+
                    "3. Password should have at least one digit.");
        }
        return true;
    }
    /*public static boolean passwordIsNeverOk(String password)throws Exception
    {
        if (password.length() < 8)
        {
            if (password.isEmpty())
            {
                throw new Exception("Password cannot be empty!");
            }
            throw new Exception("Password must be 8 characters long!");
        }

        return true;
    }*/

    public static void main(String[] args)throws Exception, IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print(
                "1. A password must have at least eight characters.\n" +
                        "2. A password consists of only letters and digits.\n" +
                        "3. A password must contain at least one digits \n" +
                        "Input a password: \n");
        String s = input.nextLine();
        int count = 0;

        if (password_is_valid(s))
        {
            System.out.println(s + ": Password is valid!");
        }
        else
        {
            System.out.println(s + ": Not a valid password!");
        }
        /*if (passwordIsOk(s))
        {
            System.out.println("Password is ok");
        }
        else
        {
            System.out.println("Password is not okay.");
        }
        passwordIsNeverOk(s);*/
        PrintWriter write = new PrintWriter(new FileWriter("log.txt"));
        for (int k = 0; k < 1; k++)
        {
            if (password_is_valid(s))
            {
                write.println(log+s + ": Password is valid!");
            }
            else
            {
                write.println(log+s + ": Not a valid password!");
            }
        }
        write.close();
    }
}



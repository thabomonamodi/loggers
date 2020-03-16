import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
                log.error("password length should be 8 characters long.");
                check=false;
            }

            if (password.isEmpty())
            {
                log.fatal("password cannot be empty.");
                check=false;
            }

            if (!password.matches("(.*[a-z].*)"))
            {
                log.error("password should contain lowercase.");
                check=false;
            }
            if (!password.matches("(.*[A-Z].*)"))
            {
                log.error("password should contain uppercase.");
                check=false;
            }

            if (!password.matches("(.*[@#$%!].*)"))
            {
                log.error("password should have at least one special case.");
                check=false;
            }
            if(!password.matches("(.*[0-9].*)"))
            {
                log.error("password should have at least one digit.");
                check=false;
            }
        }
        catch (Exception e)
        {
            log.info("make sure the above conditions are met."+e.getMessage());
        }
        return check;
    }
    public static boolean passwordIsOk(String password)
    {

        try
        {
            if ((password.length() < 8) || !password.matches("(.*[a-z].*)"))
            {
                System.out.println("Password should meet at least 3 of the conditions.\n"+
                    "1. Password length should be 8 characters long.\n"+
                    "2. Password cannot be empty.\n"+
                    "3. Password should contain lowercase.");
                return false;
            }

            if (!password.matches("(.*[A-Z].*)")|| !password.matches("(.*[@#$%!].*)") || !password.matches("(.*[0-9].*)"))
            {
                System.out.println("Password should meet at least 3 of the conditions:\n"+
                        "1. Password should contain uppercase.\n"+
                        "2. Password should have at least one special case.\n"+
                        "3. Password should have at least one digit.");
                return false;
            }
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
        }

        return true;
    }
    public static boolean passwordIsNeverOk(String password)
    {
        try{
            if (password.length() < 8)
            {
                if (password.isEmpty())
                {
                    log.error("Password cannot be empty!");
                }
                log.error("Password must be 8 characters long!");
            }
            return false;
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print(
                "1. A password must have at least eight characters.\n" +
                        "2. A password consists of only letters and digits.\n" +
                        "3. A password must contain at least one digits \n" +
                        "Input a password: \n");
        String s = input.nextLine();

        if (password_is_valid(s))
        {
            System.out.println(s + ": Password is valid!");
        }
        else
        {
            System.out.println(s + ": Not a valid password!");
        }

    }
}



import org.junit.Assert;
import org.junit.Test;

public class PasswordCheckerTest
{
    @Test
    public void testPassword_is_valid()throws Exception
    {
        /*Assert.assertEquals(PasswordChecker.password_is_valid("(.*[a-z].*)"),false);
        Assert.assertEquals(PasswordChecker.password_is_valid("(.*[A-Z].*)"),false);
        Assert.assertEquals(PasswordChecker.password_is_valid("(.*[0-9].*)"),false);
        Assert.assertEquals(PasswordChecker.password_is_valid("(.*[@#$%!].*)"),false);
        //Assert.assertEquals(PasswordChecker.password_is_valid());
        Assert.assertEquals(PasswordChecker.passwordIsNeverOk("zobaRoidz@1"),true);
        Assert.assertEquals(PasswordChecker.passwordIsOk("zobaRoidz@1"),true);
        Assert.assertEquals(PasswordChecker.password_is_valid("zobaRoidz@1"),true);*/
        Assert.assertTrue(PasswordChecker.password_is_valid("zobaRoidz@1"));
        Assert.assertTrue(PasswordChecker.passwordIsNeverOk("zobaRoidz@1"));
        Assert.assertTrue(PasswordChecker.passwordIsOk("zobaRoidz@1"));
        /*new AssertionError(PasswordChecker.password_is_valid("zobaRoidz@1"));
        new AssertionError(PasswordChecker.passwordIsOk("zobaRoidz@1"));
        new AssertionError(PasswordChecker.passwordIsNeverOk("zobaRoidz@1"));*/
    }
}

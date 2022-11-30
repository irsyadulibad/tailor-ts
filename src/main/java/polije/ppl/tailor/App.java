package polije.ppl.tailor;

import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.repository.AccountRepository;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Account acc = new Account(
            "John",
            "test@gmail.com",
            "john",
            "john123"
        );

        System.out.println(new AccountRepository().add(acc));
        System.out.println( "Hello World!" );
    }
}

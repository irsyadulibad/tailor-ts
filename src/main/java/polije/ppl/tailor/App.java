package polije.ppl.tailor;

import polije.ppl.tailor.entity.Package;
import polije.ppl.tailor.repository.PackageRepository;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Package pkg = new Package(1, 2000, "Testing");
        Package pkg2 = new Package(1, 3000, "Toast");

        PackageRepository.update(pkg, pkg2);
        System.out.println( "Hello World!" );
    }
}

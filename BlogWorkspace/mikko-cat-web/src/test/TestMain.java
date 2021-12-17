import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMain {
    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        // System.out.println(Constant.SYSTEM_DIR);
        // System.out.println(SystemConfig.globalAuthor);
        // System.out.println(GeneratorConfig.dbUrl);
        // System.out.println(Charsets.UTF_8.name());
        // System.out.println(Charsets.ISO_8859_1.name());
        logger.debug("This is debug message.");

        Thread thread = new Thread();
        thread.start();
        String name = thread.getName();
    }
}

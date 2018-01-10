package commanddemo1; /**
 * Created by Think on 2018/1/10.
 */
import org.apache.commons.cli.*;
import org.junit.Test;

public class CLI {
  @Test
    public  void test() throws ParseException {
        String arg[]={"-t 1000"};
        testParser(arg);

//      String argb[]={"-h"};
//      testParser(argb);
      String argc[]={"-block-size=10"};
      testParser(argc);
  }


    public  void testParser(String[] args) throws ParseException {
        //定义
        Options options = new Options();
        options.addOption("h",false,"list help");//false代表不强制有
        options.addOption("t",true,"set time on system");
        options.addOption( OptionBuilder.withLongOpt( "block-size" )
                .withDescription( "use SIZE-byte blocks" )
                .hasArg()
                .withArgName("SIZE")
                .create() );
        //解析
        //1.3.1中已经弃用针对不同格式入参对应的解析器
        //CommandLineParser parser = new PosixParser();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options,args);
        //查询交互
        //你的程序应当写在这里，从这里启动
        if (cmd.hasOption("h")){
            String formatstr = "CLI  cli  test";
            HelpFormatter hf = new HelpFormatter();
            hf.printHelp(formatstr, "", options, "");
            return;
        }

        if (cmd.hasOption("t")){
            System.out.printf("system time has setted  %s \n",cmd.getOptionValue("t"));
            return;
        }
        if( cmd.hasOption( "block-size" ) ) {
            // print the value of block-size
            System.out.println( cmd.getOptionValue( "block-size" ) );
        }

        System.out.println("error");
    }
}
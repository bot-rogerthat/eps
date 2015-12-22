package cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PatternOptionBuilder;


public class Parser {
    private Options options;

    public Parser(){
        options = new Options();
        options.addOption(Option.builder("m")
                .longOpt("m")
                .desc("row")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());
        options.addOption(Option.builder("n")
                .longOpt("n")
                .desc("column")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());
        options.addOption(Option.builder("f")
                .longOpt("f")
                .desc("FILL_FACTOR")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());

    }

    public Input parse(String[] args){
        return null;
    }
}

package cli;

import org.apache.commons.cli.*;


public class Parser {
    private Options options;

    public Parser() {
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

    public Input parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Input input = null;
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.getOptions().length == 3 && cmd.hasOption("m") && cmd.hasOption("n") && cmd.hasOption("f")) {
                input = new Input(new String[]{cmd.getOptionValue("m"), cmd.getOptionValue("n"), cmd.getOptionValue("f")});
            }
        } catch (ParseException e) {
            HelpFormatter help = new HelpFormatter();
            help.printHelp("help", options);
        }
        return input;
    }
}

package cli;

import org.apache.commons.cli.*;


public class Parser {
    private Options options;

    public Parser() {
        options = new Options();
        options.addOption(Option.builder("m")
                .desc("row")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());
        options.addOption(Option.builder("n")
                .desc("column")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());
        options.addOption(Option.builder("f")
                .desc("fill factor")
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
            if (checkParameters(cmd)) {
                input = new Input(new String[]{cmd.getOptionValue("m"), cmd.getOptionValue("n"), cmd.getOptionValue("f")});
            }
        } catch (ParseException e) {
            HelpFormatter help = new HelpFormatter();
            help.printHelp("command line parameters for eps", options);
        }
        return input;
    }

    private boolean checkParameters(CommandLine cmd) {
        return cmd != null && cmd.getOptions().length == 3 && cmd.hasOption("m") && cmd.hasOption("n") && cmd.hasOption("f");
    }
}

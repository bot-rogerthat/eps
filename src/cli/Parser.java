package cli;

import org.apache.commons.cli.*;


public class Parser {
    private Options options;

    public Parser() {
        options = new Options();
        options.addOption(Option.builder("m")
                .desc("row > 0")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());
        options.addOption(Option.builder("n")
                .desc("column > 0")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());
        options.addOption(Option.builder("f")
                .desc("fill factor 0.0 to 1.0")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());
    }

    public Matrix parse(String[] args) {
        HelpFormatter help = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        Matrix matrix = null;
        try {
            CommandLine cmd = parser.parse(options, args);
            if (checkParameters(cmd) && paramsIsValid(cmd)) {
                int m = Integer.parseInt(cmd.getOptionValue("m"));
                int n = Integer.parseInt(cmd.getOptionValue("n"));
                double f = Double.parseDouble(cmd.getOptionValue("f"));
                matrix = new Matrix(m, n, f);
            } else {
                help.printHelp("command line parameters for eps", options);
                System.exit(0);
            }
        } catch (ParseException | IllegalArgumentException e) {
            help.printHelp("command line parameters for eps", options);
        }
        return matrix;
    }

    private boolean checkParameters(CommandLine cmd) {
        return cmd.getOptions().length == 3 && cmd.hasOption("m") && cmd.hasOption("n") && cmd.hasOption("f");
    }

    private boolean paramsIsValid(CommandLine cmd) {
        return Integer.parseInt(cmd.getOptionValue("m")) > 0 && Integer.parseInt(cmd.getOptionValue("n")) > 0
                && Double.parseDouble(cmd.getOptionValue("f")) >= 0.0 && Double.parseDouble(cmd.getOptionValue("f")) <= 1.0;
    }
}

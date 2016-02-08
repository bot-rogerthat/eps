package com.epam.eps;

import org.apache.commons.cli.*;

public class Parser {

    private Options options;

    public Parser() {
        options = new Options();
        options.addOption(Option.builder("m")
                .desc("height > 0")
                .hasArg()
                .required()
                .type(PatternOptionBuilder.NUMBER_VALUE)
                .build());
        options.addOption(Option.builder("n")
                .desc("width > 0")
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

    public Options getOptions() {
        return options;
    }

    public Input parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Input input = new Input(0, 0, 0);
        try {
            CommandLine cmd = parser.parse(options, args);
            int m = Integer.parseInt(cmd.getOptionValue("m"));
            int n = Integer.parseInt(cmd.getOptionValue("n"));
            double f = Double.parseDouble(cmd.getOptionValue("f"));
            input = new Input(m, n, f);
        } catch (ParseException ignored) {
        }
        return input;
    }
}

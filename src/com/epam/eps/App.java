package com.epam.eps;

import com.epam.eps.locator.Locator;
import com.epam.eps.locator.DFSLocator;
import com.epam.eps.sector.RandomSector;
import com.epam.eps.sector.Sector;
import com.epam.eps.sector.SectorSource;
import org.apache.commons.cli.HelpFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        HelpFormatter help = new HelpFormatter();
        Parser parser = new Parser();
        try {
            Input input = parser.parse(args);
            SectorSource area = new RandomSector(input.getHeight(), input.getWidth(), input.getFillFactor());
            Sector sector = area.getSector();

            List<RiskGroup> groupOfRisk = Arrays.asList(new RiskGroup("NONE", 1, 2), new RiskGroup("MINOR", 3, 4),
                    new RiskGroup("NORMAL", 5, 7), new RiskGroup("MAJOR", 8, 13),
                    new RiskGroup("CRITICAL", 14, Integer.MAX_VALUE));

            Locator locator = new DFSLocator(sector, groupOfRisk);
            Map<RiskGroup, Integer> foundGroups = locator.find();

            Reporter reporter = new Reporter();
            System.out.println(reporter.getReport(sector, input.getFillFactor(), foundGroups, groupOfRisk));
        } catch (Exception e) {
            help.printHelp("command line parameters for eps", parser.getOptions());
        }
    }
}

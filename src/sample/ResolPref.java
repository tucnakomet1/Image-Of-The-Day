package sample;

import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ResolPref {
    static Main mn = new Main();
    static Class cls = mn.getClass();

    public ResolPref() {}

    public static ArrayList<String> get_pref_resolution() throws IOException, ParseException {
        ArrayList<String> sites = new ArrayList(Arrays.asList("Unsplash", "Big Geek Daddy", "National Geographic", "APOD NASA", "Wikimedia Common", "EPOD-USRA", "NASA", "Bing", "NESDIS-NOAA", "Earth Observatory"));
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> TOP = new ArrayList<>();
        ArrayList<String> OK_PREF_W = new ArrayList<>();
        ArrayList<String> OK_PREF_H = new ArrayList<>();
        ArrayList<String> OK = new ArrayList<>();
        ArrayList<String> SQUARE = new ArrayList<>();
        ArrayList<String> TALL = new ArrayList<>();
        ArrayList<String> NOTHING = new ArrayList<>();

        for (String site : sites){
            URL sitUrl = cls.getResource("/JSON_data/resolution.json");
            String sitex =  ReadJson.GetElement(site, new FileReader(sitUrl.getPath()));
            String[] splitted = sitex.split("x");
            int WIDTH = Integer.parseInt(splitted[0]);
            int HEIGHT = Integer.parseInt(splitted[1]);

            if (sitex.equals("580x326")){
                TOP.add(site);
            }
            else if (WIDTH == HEIGHT) {
                SQUARE.add(site);
            }
            else if (sitex.equals("100x300")){
                NOTHING.add(site);
            }
            else if ((WIDTH < HEIGHT) && !sitex.equals("100x300")){
                TALL.add(site);
            }
            else {
                if (WIDTH == 580){
                    OK_PREF_W.add(site);
                }
                else if (HEIGHT == 386) {
                    OK_PREF_H.add(site + ": " + sitex);
                }
                else {
                    OK.add(site);
                }
            }
        }

        ArrayList<Integer> res_val = new ArrayList<>();
        ArrayList<Integer> new_res_val = new ArrayList<>();
        ArrayList<String> OK_PREF_H_RESULT = new ArrayList<>();

        for (String someName : OK_PREF_H) {
            String[] one = someName.split(": ");
            String[] two = one[1].split("x");
            int width = Integer.parseInt(two[0]);
            res_val.add(width);
        }

        Integer[] values = res_val.toArray(new Integer[res_val.size()]);
        Arrays.sort(values, Collections.reverseOrder());
        Collections.addAll(new_res_val, values);
        for (Integer integer : new_res_val) {
            for (String RES : OK_PREF_H) {
                String[] oneONE = RES.split(": ");
                String[] twoTWO = oneONE[1].split("x");
                String widthWIDTH = twoTWO[0];
                if (widthWIDTH.contains(integer.toString()) && !OK_PREF_H_RESULT.contains(oneONE[0])) {
                    OK_PREF_H_RESULT.add(oneONE[0]);
                }
            }
        }

        result.addAll(TOP);
        result.addAll(OK_PREF_W);
        result.addAll(OK_PREF_H_RESULT);
        result.addAll(OK);
        result.addAll(SQUARE);
        result.addAll(TALL);
        result.addAll(NOTHING);

        return result;
    }
}
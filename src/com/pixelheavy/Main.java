package com.pixelheavy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        String pageText = loadUrl("http://www.kidsnpetsbrand.com");
        List<String> anchors = getAnchors(pageText);
        String firstAnchor = anchors.get(0);
        //start at root
        //call crawlPage
    }

    private static void crawlPage(String url, String rootUrl, String baseUrl){
        //find base url (no querystring or fragment)
        //find root url (up to first slash)
        //load page
        //compile list of all href's (joining onto root or base as appropriate)
        //recurse for each
        //will this blow the stack?

    }

    private static List<String> getAnchors(String pageText){
        String regex = "<a\\s+(?:[^>]*?\\s+)?href\\s*=\\s*\"([^\"]*)\"";
        List<String> anchors = new ArrayList<>();

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pageText);
        while (m.find()) {
            String anchor = m.group(0);
            anchors.add(anchor);
        }
        return anchors;
    }

    private static String loadUrl(String url) throws IOException {
        StringBuilder pageText = new StringBuilder();
        InputStream in = new URL(url).openStream();
        try {
            InputStreamReader inR = new InputStreamReader( in );
            BufferedReader buf = new BufferedReader( inR );
            String line;
            while ( ( line = buf.readLine() ) != null ) {
                pageText.append(line);
            }
        } finally {
            in.close();
        }

        return pageText.toString();
    }
}

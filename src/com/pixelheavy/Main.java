package com.pixelheavy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        //start at root
        //call crawlPage
    }

    private void crawlPage(String url, String rootUrl, String baseUrl){
        //find base url (no querystring or fragment)
        //find root url (up to first slash)
        //load page
        //compile list of all href's (joining onto root or base as appropriate)
        //recurse for each
        //will this blow the stack?

    }

    private List<String> getAnchors(String pageText){

    }

    private String LoadUrl(String url) throws IOException {
        InputStream in = new URL(url).openStream();
        try {
            InputStreamReader inR = new InputStreamReader( in );
            BufferedReader buf = new BufferedReader( inR );
            String line;
            while ( ( line = buf.readLine() ) != null ) {
                System.out.println( line );
            }
        } finally {
            in.close();
        }

    }
}

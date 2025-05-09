package com.wsboot;

import java.io.IOException;

public class openbrowser {


	public void openbrowser(String url) throws IOException{
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
    }
	

}

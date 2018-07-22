/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kashif.callcentercustomerinformation.httpclients;

import com.kashif.callcentercustomerinformation.models.HTTPGetClientOutput;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;

/**
 *
 * @author mostafa.kashif
 */
public class HTTPGetClient {

    private static final Logger logger = Logger.getLogger(HTTPGetClient.class);
    
    public static HTTPGetClientOutput callHTTPGet(String httpUrl) throws Exception {
        try {

            URL url = new URL(httpUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            HTTPGetClientOutput output = new HTTPGetClientOutput();


            output.setHttpResponseCode(conn.getResponseCode());
            if(conn.getResponseCode()==200)
            {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String outputString;
            StringBuilder outputBuilder = new StringBuilder();
            
            while ((outputString = br.readLine()) != null) {

                outputBuilder.append(outputString);
            }
            output.setOutput(outputBuilder.toString());
            }
            conn.disconnect();
            return output;
            
        } catch (MalformedURLException e) {

            logger.error("MalformedURLException while calling url:" + httpUrl + ",e:" + e,e);
            throw e;
        } catch (IOException e) {

            logger.error("IOException while calling url:" + httpUrl + ",e:" + e,e);
            throw e;

        } catch (Exception e) {

            logger.error("Exception while calling url:" + httpUrl + ",e:" + e,e);
            throw e;

        }

    }
}

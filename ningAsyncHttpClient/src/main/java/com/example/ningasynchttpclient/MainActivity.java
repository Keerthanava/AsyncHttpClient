package com.example.ningasynchttpclient;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import com.ning.http.client.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainActivity extends Activity {



    String ResponseBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView result=(TextView)findViewById(R.id.tvjaxrs);

        AsyncHttpClient client = new AsyncHttpClient();

        try{
            Future<Response>f=client.preparePost("http://api.openkeyval.org").addParameter("locnew","UnitedStatesOfAmerica").execute();
           // ResponseBody = f.get().getResponseBody();
           // result.setText(ResponseBody);
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            Future<Response>f = client.prepareGet("http://api.openkeyval.org/locnew").execute();
            ResponseBody =f.get().getResponseBody();
            result.setText(ResponseBody);

        }catch(Exception e){
            e.printStackTrace();
        }

       /* try{
        client.prepareGet("http://api.openkeyval.org/locnew").execute(new AsyncCompletionHandler<Response>() {
            @Override
            public Response onCompleted(Response response) throws Exception {
                return response;


            }

            @Override
            public void onThrowable(Throwable t){
                // Something wrong happened.
            }
        });
        }catch(IOException e){
            e.printStackTrace();
        }*/


      /*  try{
       Future<Response> f= client.prepareGet("http://api.openkeyval.org/loc12345").execute();
       // String ResponseBody = (String)f.get();
            InputStream content = (InputStream)f.get();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
            StringBuffer stringBuffer = new StringBuffer("");
            String s = "";
            while((s=buffer.readLine())!=null){
                stringBuffer.append(s);

            }
            buffer.close();
            result.setText(stringBuffer.toString());

        }catch(IOException e){
            e.printStackTrace();
      }catch(InterruptedException e){
            e.printStackTrace();
    }catch(ExecutionException e){
            e.printStackTrace();
        }*/


    }


    }



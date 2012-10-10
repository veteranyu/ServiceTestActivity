package com.ijoyplus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceTestActivity extends Activity {
	private static final String TAG             = "ServiceTestActivity";
	
	private Button mTestButtom;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mTestButtom = (Button) findViewById(R.id.button1);
        mTestButtom.setOnClickListener(mTestButtomListener);
    }
    private OnClickListener mTestButtomListener = new OnClickListener() {
        public void onClick(View v) {
        	/*
            Intent intent =
                    new Intent(MediaPlayerDemo.this.getApplication(),
                            MediaPlayerDemo_Audio.class);
            intent.putExtra(MEDIA, LOCAL_AUDIO);
            startActivity(intent);
			*/
        	/*
        	String pageContent = null;
        	 Context context = getApplicationContext();;
        	 try {
                 // Try querying the Wiktionary API for today's word
        		 SimpleWikiHelper.prepareUserAgent(context);
                 pageContent = SimpleWikiHelper.getPageContent("t1", false);
             } catch (ApiException e) {
                 Log.e("WordWidget", "Couldn't contact API", e);
             } catch (ParseException e) {
                 Log.e("WordWidget", "Couldn't parse API response", e);
             } catch (com.ijoyplus.Video.SimpleWikiHelper.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		*/

        	try {
        		OnHttpResponse();//OnHttpPost();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        	//testFunction();
        }
    };
    public void OnHttpResponse() throws ClientProtocolException, IOException, JSONException { 
    	HttpClient httpClient = new DefaultHttpClient();
    	int i = Constant.TESTINDEX;
    	Log.i(TAG," -- OnHttpResponse begain");
    	while(i<Constant.m_URL.length){
    		if(Constant.m_URL[i][2].indexOf("POST") != -1){
    			OnHttpPost(httpClient,i);
    			
    		}
    		else if(Constant.m_URL[i][2].indexOf("GET") != -1){
    			OnHttpGet(httpClient,i);
    		}
    		i++;
    	}
    	String strTotle = "\nTotle test services:\n"+ String.valueOf( i +1 -Constant.TESTINDEX );
    	 appendLog(strTotle);
    	 TextView tv = (TextView)findViewById(R.id.textView1);
         tv.setText(strTotle + "\n ijoyplus service test end, Please check your"+ Constant.OUTPUTFILE + "file in sdcard!");
    	//Toast.makeText(getApplicationContext(), "ijoyplus service test end, Please find test log file in sdcard!", Toast.LENGTH_SHORT).show();
    }
    	   public void OnHttpPost(HttpClient httpClient,int index) throws ClientProtocolException, IOException, JSONException {  
    		// TODO 状态处理 500 200 
               int res = 0;
               StringBuilder builder = new StringBuilder(); 
               
               Log.i(TAG," -- OnHttpPost" + Constant.m_URL[index][1]);
               
               String m_PostURL = Constant.m_URL[index][1];
               int PostNum = Integer.parseInt(Constant.m_URL[index][3]);
               int ReturnNum = 0;
               int ReturnIndex = 0;
               int i=2;//from POST search "RETURN" can get number
               while(!Constant.m_URL[index][i].isEmpty()){
            	   if(Constant.m_URL[index][i].indexOf("RETURN") != -1){
            		   ReturnIndex = i+1;
            		   break;
            	   }
            	   i++;
               }
               
               if(Constant.m_URL[index][ReturnIndex].toUpperCase().indexOf("XML") == -1)
            	   ReturnNum = Integer.parseInt(Constant.m_URL[index][ReturnIndex]);
               
               HttpPost httpPost = new HttpPost(m_PostURL);
               //save
               builder.append("\n\nURL:\n"+m_PostURL);
               builder.append("\nMethod:\nPOST");
// { "kPathAccountRegister ", BASE_URL +"account/register","POST","4","app_key","username","password","nickname","RETURN","2","res_code","res_desc"},
               try { 
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(PostNum); 
                
                String tempMail;
                if(index == 2)
                	tempMail = "T_" + getRandomString(6);
                else
                	tempMail = Constant.TEMPMAIL;
              //post DATA ,except Constant.APPKEY
                for(i = 0; i<PostNum;i++){
                	if(Constant.m_URL[index][4+i].indexOf("app_key") != -1){
                		 nameValuePairs.add(new BasicNameValuePair(Constant.m_URL[index][4+i], Constant.APPKEY)); 
                		 builder.append("\n" + Constant.m_URL[index][4+i] + ":\n" + Constant.APPKEY);
                	}
                	else if(Constant.m_URL[index][4+i].indexOf("username") != -1){
                		nameValuePairs.add(new BasicNameValuePair(Constant.m_URL[index][4+i], tempMail + "@163.com")); 
                		builder.append("\n" + Constant.m_URL[index][4+i] + ":\n" + tempMail + "@163.com");
                	}
                	else if(Constant.m_URL[index][4+i].indexOf("source_type") != -1 ||
                			Constant.m_URL[index][4+i].indexOf("where") != -1 ||
                			Constant.m_URL[index][4+i].indexOf("page_num") != -1){
                		nameValuePairs.add(new BasicNameValuePair(Constant.m_URL[index][4+i], "1")); 
                		builder.append("\n" + Constant.m_URL[index][4+i] + ":\n" + "1");
                	}
                	//page_size
                	else if(Constant.m_URL[index][4+i].indexOf("page_size") != -1 ||
                			Constant.m_URL[index][4+i].indexOf("num") != -1){
                		nameValuePairs.add(new BasicNameValuePair(Constant.m_URL[index][4+i], "10")); 
                		builder.append("\n" + Constant.m_URL[index][4+i] + ":\n" + "10");
                	}
                	else if(Constant.m_URL[index][4+i].indexOf("prod_id") != -1){
                		nameValuePairs.add(new BasicNameValuePair(Constant.m_URL[index][4+i], Constant.PROD_ID)); 
                		builder.append("\n" + Constant.m_URL[index][4+i] + ":\n" + Constant.PROD_ID);
                	}
                	else{
                		nameValuePairs.add(new BasicNameValuePair(Constant.m_URL[index][4+i], tempMail));
                		//save
                        builder.append("\n" + Constant.m_URL[index][4+i] + ":\n" +tempMail);
                	}
                	
                }

                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs)); 
              
                
                HttpResponse httpResponse = httpClient.execute(httpPost); 
                res = httpResponse.getStatusLine().getStatusCode(); 
                if (res == 200) { 
                    /* 
                     * 当返回码为200时，做处理 
                     * 得到服务器端返回json数据，并做处理 
                     * */ 
                	StringBuilder ReturnBuilder = new StringBuilder(); 
                    BufferedReader bufferedReader2 = new BufferedReader( 
                            new InputStreamReader(httpResponse.getEntity().getContent())); 
                    String str2 = "";
                    builder.append("\nRETURN:\n"); 
                    for (String s = bufferedReader2.readLine(); s != null; s = bufferedReader2 
                            .readLine()) { 
                       // builder.append(s); 
                        ReturnBuilder.append(s);
                    } 
                    Log.i("cat", ">>>>>>" + builder.toString());
                   
                    if(!ReturnBuilder.toString().trim().isEmpty()){
                    	JSONObject jsonObject = new JSONObject(ReturnBuilder.toString()) ;
                    	builder.append(jsonObject.toString());
                    }
                   // JSONObject jsonObject = new JSONObject(builder.toString()) ;
                    /*
                       // .getJSONObject("res_code");
                    for(i = 0; i<ReturnNum;i++){
                    	nameValuePairs.add(new BasicNameValuePair(Constant.m_URL[index][ReturnIndex+i], "12345")); 
                    }
                String res_code; 
                String res_desc; 
                String Avtar; 
                String State;
                res_code = jsonObject.getString("res_code"); 
                res_desc = jsonObject.getString("res_desc"); 
                //Avtar = jsonObject.getString("Avtar"); 
               // State = jsonObject.getString("State");
                
                */
                }
               } catch (ClientProtocolException e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 
               } catch (IOException e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 
               } 
               
               appendLog(builder.toString());
               
    	   }
    	   public void OnHttpGet(HttpClient client,int index) throws ClientProtocolException, IOException, JSONException {  
    		   
    		   Log.i(TAG," -- OnHttpGet" + Constant.m_URL[index][1]);
    	        StringBuilder builder = new StringBuilder();
    	        String m_GetURL = Constant.m_URL[index][1];
    	        int GetNum = Integer.parseInt(Constant.m_URL[index][3]);
                int ReturnNum = 0;
                int ReturnIndex = 0;
    	       
                //{ "kPathAccountLogout ", BASE_URL +"account/logout","GET","1","app_key","2","res_code","res_desc"},
                int i=2;//from POST search "RETURN" can get number
                while(!Constant.m_URL[index][i].isEmpty()){
             	   if(Constant.m_URL[index][i].indexOf("RETURN") != -1){
             		   ReturnIndex = i+1;
             		   break;
             	   }
             	   i++;
                }
                
                if(Constant.m_URL[index][ReturnIndex].toUpperCase().indexOf("XML") == -1)
                	ReturnNum = Integer.parseInt(Constant.m_URL[index][ReturnIndex]);
                //HttpPost httpGet = new HttpPost(m_GetURL);
                //save
                //builder.append("\n\nURL:\n"+m_GetURL);
    	        
    	       
    	        try {
    	        	
                    String nameValuePairs = "?";
                    boolean isHaveFirstPair = false;
                    String tempMail;
                    StringBuilder ReturnBuilder = new StringBuilder(); 
                    
                    if(index == 2)
                    	tempMail = "T_" + getRandomString(6);
                    else
                    	tempMail = Constant.TEMPMAIL;
                  //post DATA ,except Constant.APPKEY
                    for(i = 0; i<GetNum;i++){
                    	if(Constant.m_URL[index][4+i].indexOf("app_key") != -1){
                    		if(!isHaveFirstPair){
                    			nameValuePairs = nameValuePairs +Constant.m_URL[index][4+i]+ "=" + Constant.APPKEY;
                    			isHaveFirstPair = true;
                    		}
                    		else
                    			nameValuePairs = nameValuePairs +"&"+ Constant.m_URL[index][4+i]+ "=" + Constant.APPKEY; 
                    		
                    	}
                    	else if(Constant.m_URL[index][4+i].indexOf("username") != -1){
                    		if(!isHaveFirstPair){
                    			nameValuePairs = nameValuePairs + Constant.m_URL[index][4+i]+ "=" + tempMail + "@163.com";
                    			isHaveFirstPair = true;
                    		}
                    		else
                    			nameValuePairs = nameValuePairs +"&"+ Constant.m_URL[index][4+i]+ "=" + tempMail + "@163.com";
                    		
                    	}
                    	else if(Constant.m_URL[index][4+i].indexOf("source_type") != -1 ||
                    			Constant.m_URL[index][4+i].indexOf("page_num") != -1 ||
                    			Constant.m_URL[index][4+i].indexOf("where") != -1){
                    			nameValuePairs = nameValuePairs + "&"+ Constant.m_URL[index][4+i]+ "=" + "1";
                    	}
                    	else if(Constant.m_URL[index][4+i].indexOf("prod_id") != -1){
                    		nameValuePairs = nameValuePairs + "&"+ Constant.m_URL[index][4+i]+ "=" + Constant.PROD_ID; 
                    	}
                    	//page_size
                    	else if(Constant.m_URL[index][4+i].indexOf("page_size") != -1 ||
                    			Constant.m_URL[index][4+i].indexOf("num") != -1){
                    		nameValuePairs = nameValuePairs + "&"+ Constant.m_URL[index][4+i]+ "=" + "10"; 
                    	}
                    	else{
                    		if(!isHaveFirstPair){
                    			nameValuePairs = nameValuePairs + Constant.m_URL[index][4+i]+ "=" + tempMail;
                    			isHaveFirstPair = true;
                    		}
                    		else
                    			nameValuePairs = nameValuePairs +"&"+ Constant.m_URL[index][4+i]+ "=" + tempMail;
                    		
                    	}
                    	
                    }
                    m_GetURL  = m_GetURL + nameValuePairs;
                    //save to log
                    builder.append("\n\nURL:\n" + m_GetURL);
                    builder.append("\nMethod:\nGET");
                    
                    HttpGet get = new HttpGet(m_GetURL);
                    
                  //save
                    builder.append("\n" + Constant.m_URL[index][4+i] + ":\n" +tempMail);
                    
    	            HttpResponse response = client.execute(get);
    	            BufferedReader reader = new BufferedReader(new InputStreamReader(
    	                    response.getEntity().getContent()));
    	            builder.append("\nRETURN:\n"); 
    	            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
    	                //builder.append(s);
    	                ReturnBuilder.append(s);
    	            }
    	            
    	            if(!ReturnBuilder.toString().trim().isEmpty()){
                    	JSONObject jsonObject = new JSONObject(ReturnBuilder.toString()) ;
                    	builder.append(jsonObject.toString());
    	            }
                    	
    	           // JSONObject jsonObject = new JSONObject(builder.toString());
    	            /*
    	            String res_code; 
    	               String res_desc; 
    	               String Avtar; 
    	               String State;
    	               res_code = jsonObject.getString("res_code"); 
    	               res_desc = jsonObject.getString("res_desc"); 
    	               */
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
    	        appendLog(builder.toString());
       	   }
    	   public void appendLog(String text)
    	   {       
    	      File logFile = new File(Constant.OUTPUTFILE);
    	      if (!logFile.exists())
    	      {
    	         try
    	         {
    	            logFile.createNewFile();
    	         } 
    	         catch (IOException e)
    	         {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	         }
    	      }
    	      try
    	      {
    	         //BufferedWriter for performance, true to set append to file flag
    	        // BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true)); 
    	    	  BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile,true), "GB2312"));
    	         buf.append(text.toString());
    	         buf.flush();
    	         buf.newLine();
    	         buf.close();
    	      }
    	      catch (IOException e)
    	      {
    	         // TODO Auto-generated catch block
    	         e.printStackTrace();
    	      }
    	   }
    	   
		
    	   /*  
    	     * 获取随机字符串  
    	     * 实现方法很多，也很简单，但是对这种简单的东西，开发者有时候就是不想去敲键盘  
    	     * 但是不敲就做不下去，本来在此愿意成全和我一样有此烦恼的开发者  
    	     */  
    	    public static String getRandomString(int len){  
    	        String returnStr="";  
    	        char[] ch=new char[len];  
    	        Random rd=new Random();  
    	        for(int i=0;i<len;i++){  
    	            ch[i]=(char)(rd.nextInt(9)+97);  
    	        }  
    	        returnStr=new String(ch);  
    	        return returnStr;  
    	    }  
    	    public void testFunction(){
    	    	String fileName=Constant.OUTPUTFILE;
    	    	         String content="問題怎么解決﹖汉字の本";
    	    	         String strEncode="UTF-8";

    	    	         BufferedWriter writer = null;
    	    	         try {
    	    	                 File file = new File(fileName);
    	    	                // createFolders(file.getParent());
    	    	                 writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), strEncode));
    	    	                 writer.write(content);
    	    	                 writer.flush();
    	    	         } catch (IOException e) {
    	    	                 System.out.println(e);
    	    	                 //return false;
    	    	         } finally {
    	    	                 try {
    	    	                         writer.close();
    	    	                 } catch (IOException e) {
    	    	                         e.printStackTrace();
    	    	                 }
    	    	         }
    	    }

}
package org.androidtown.covid19center.Network;

import android.util.Log;
import android.view.View;

import org.androidtown.covid19center.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {

    String key = "RXCd%2Ft3knwTw6er%2F6WYBiqoU4JxZBAPUgeYsXSaKwKHc%2FX9fBQXF9ISg31XMxT6r0BlYer0GT9NfnnLWN8kjnA%3D%3D"; // 발급받은 인증 키
    String data;

    public void mOnClick(){


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        data = getXmlData();
                        Log.d("태순", "run");
                    }
                }).start();

        }


    String getXmlData(){
        StringBuffer buffer = new StringBuffer();

        String str = "대전";
        String location = URLEncoder.encode(str); // 한글의 경우 인식이 안되기에 utf-8방식으로 전송
        String queryUrl = "http://apis.data.go.kr/B551182/pubReliefHospService/getpubReliefHospList?" // 요청 URL
                 +"ServiceKey=" +key+ "&pageNo=2&numOfRows=100"+"&spclAdmTyCd="+"A0";

        try {
            URL url = new URL(queryUrl); // 문자열로 된 요청 url을 URL 객체로 생성
            InputStream is = url.openStream(); // url위치로 입력스트림 연결

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8"));

            String tag;
            xpp.next();
            int eventType = xpp.getEventType();

            while ( eventType != XmlPullParser.END_DOCUMENT){

                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;
                    case XmlPullParser.START_TAG:
                        tag = xpp.getName(); // 태그 이름 얻어오기

                        if(tag.equals("item")) ;
                        else if(tag.equals("sidoNm")){
                            buffer.append("시도명 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");

                        } else if(tag.equals("sgguNm")){
                            buffer.append("시군구명 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        } else if(tag.equals("yadmNm")){
                            buffer.append("기관명 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        } else if(tag.equals("hospTyTpCd")){
                            buffer.append("선정유형 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        } else if(tag.equals("telno")){
                            buffer.append("전화번호 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        } else if(tag.equals("adtFrDd")){
                            buffer.append("운영가능 일자 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        } else if(tag.equals("spclAdmTyCd")){
                            buffer.append("구분코드 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        break;
                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //태그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈

                        break;
                }

                eventType= xpp.next();


            }

        } catch (Exception e){
                Log.d("태순","오류");
        }
        Log.d("태순",String.valueOf(buffer));
        buffer.append("파싱 끝");
        return buffer.toString();
    }
}
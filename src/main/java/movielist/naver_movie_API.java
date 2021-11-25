package movielist;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import movielist.MovieDetailBean;

public class naver_movie_API {

	public MovieDetailBean naverApi(String title)  {
		String clientId = "pE3wgWDVLSb_IaO6KBkq"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "NXH6oRYwvW"; //애플리케이션 클라이언트 시크릿값"
        
        String text = null;
        try {
            //Scanner scan = new Scanner(System.in);
           // String str;
            System.out.println("검색어:"+title);
           // str = scan.nextLine();
            text = URLEncoder.encode(title, "UTF-8"); 
            //scan.close();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
 
        String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text + "&display=1&start=1";    // json 결과
       // String apiURL = "https://openapi.naver.com/v1/search/movie.json";    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
 
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);
        
 
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;
        JSONArray infoArray =null;
		try {
			jsonObject = (JSONObject) jsonParser.parse(responseBody);
			infoArray = (JSONArray) jsonObject.get("items");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MovieDetailBean mdb = null;
		//infoArray.size();
		try {
        for(int i = 0; i < infoArray.size();  i++) {
        	
       
            JSONObject itemObject = (JSONObject) infoArray.get(i);
            mdb =  new MovieDetailBean();
            
            mdb.setImage((String)itemObject.get("image"));
            mdb.setUserRating((String)itemObject.get("userRating"));
            mdb.setTitle((String)itemObject.get("title"));
            System.out.println("네이버 api 타이틀:"+mdb.getTitle());
            mdb.setSubtitle((String)itemObject.get("subtitle"));
            mdb.setPubDate((String)itemObject.get("pubDate"));
            mdb.setDirector((String)itemObject.get("director"));
            mdb.setActor((String)itemObject.get("actor"));
            mdb.setLink((String)itemObject.get("link"));
            
            // 무비 빈 타입에 넣고 array 리스트로 담아서 넘겨서 출력하기
            //https://movie-phinf.pstatic.net/20190528_36/1559024198386YVTEw_JPEG/movie_image.jpg
        }
		}catch (NullPointerException e) {
			System.out.println("NullPointerException 발생");
          
        	  mdb.setImage("http://folo.co.kr/img/gm_noimage.png");
        	  mdb.setUserRating("없음");
        	  mdb.setTitle("없음");
        	  mdb.setSubtitle("없음");
        	  mdb.setPubDate("없음");
        	  mdb.setDirector("없음");
        	  mdb.setActor("없음");
        	  mdb.setLink("없음");
		}
        return mdb;
    }
	private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }
 
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }
 
    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }
 
    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);
 
        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();
 
            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }
 
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

}
            


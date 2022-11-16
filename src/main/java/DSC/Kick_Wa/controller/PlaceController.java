package DSC.Kick_Wa.controller;

import DSC.Kick_Wa.dto.SavePlaceRequestDto;
import DSC.Kick_Wa.response.DefaultRes;
import DSC.Kick_Wa.response.StatusCode;
import DSC.Kick_Wa.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    @Value("${apikey.busStation}")
    private String busStation;

    @GetMapping("/api/load")
    public ResponseEntity loadJsonFromApi(){
        StringBuffer result = new StringBuffer();
        try{
            URL url = new URL(busStation);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-type", "application/json");

            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            result.append(bf.readLine());

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result.toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("data");
            for(int i=0; i<jsonArray.size(); i++){
                JSONObject object = (JSONObject) jsonArray.get(i);
                String name = (String) object.get("정류소명");
                String longitude = (String) object.get("경도");
                String latitude = (String) object.get("위도");
                SavePlaceRequestDto savePlaceRequestDto = new SavePlaceRequestDto(name,longitude,latitude);
                placeService.savePlace(savePlaceRequestDto);
            }
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, "open api 호출 완료!!"), HttpStatus.OK);
       } catch(Exception e){
            return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
       }
   }
}

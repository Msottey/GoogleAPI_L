package com.company;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.*;
import java.util.Scanner;

public class Distance_Model {

    //inputs
    String originLongitude = "0.000";
    String originLatitude = "0.0000";
    String destLongitude = "0.000";
    String destLatitude = "0.0000";
    String departureTime = "5:00 PM CST";
    String transitmode = "transit";
    String trafficModel = "bestguess";


    //final variables
    final String units = "imperial";
    final String key = "";
    final String url = "https://maps.googleapis.com/maps/api" +
            "/distancematrix/json";
    final String charset = "UTF-8";

    //variables
    InputStream response;

    //outputs
    Long duration, distance;
    Float cost;

    //constructors
    Distance_Model(String olat, String olon, String dlat, String dlon, String depTime, String mode, String trafficModel ){

        this.setOriginLatitude(olat);
        this.setOriginLongitude(olon);
        this.setDestLatitude(dlat);
        this.setDestLongitude(dlon);
        this.setDepartureTime(depTime);
        this.setTransitmode(mode);
        this.setTrafficModel(trafficModel);
    }

    Distance_Model (){}

    public void parseJSONDuration()  {


        try (Scanner scanner = new Scanner(this.getResponse())){
            String responseBody = scanner.useDelimiter("\\A").next();

            JSONObject json = new JSONObject(responseBody);
            //System.out.print(responseBody);
            JSONObject rows = (JSONObject) json.getJSONArray("rows").get(0);
            JSONObject elements = (JSONObject) rows.getJSONArray("elements").get(0);
            this.setDuration( (Long) elements.getJSONObject("duration").get("value"));

        }



    }

    public void parseJSONDistance()  {


        try (Scanner scanner = new Scanner(this.getResponse())){
            String responseBody = scanner.useDelimiter("\\A").next();

            JSONObject json = new JSONObject(responseBody);
            //System.out.print(responseBody);
            JSONObject rows = (JSONObject) json.getJSONArray("rows").get(0);
            JSONObject elements = (JSONObject) rows.getJSONArray("elements").get(0);
            this.setDuration( (Long) elements.getJSONObject("distance").get("value"));

        }



    }

    public void parseJSONCost()  {


        try (Scanner scanner = new Scanner(this.getResponse())){
            String responseBody = scanner.useDelimiter("\\A").next();

            JSONObject json = new JSONObject(responseBody);
            //System.out.print(responseBody);
            JSONObject rows = (JSONObject) json.getJSONArray("rows").get(0);
            JSONObject elements = (JSONObject) rows.getJSONArray("elements").get(0);
            this.setCost((Float) elements.getJSONObject("cost").get("value"));

        }

    }


    public InputStream getResponse() {

        try {
            String query = String.format("units=%s&origins=%s&destinations=%s&key=%s", URLEncoder.encode(originLatitude, charset),
                    URLEncoder.encode(originLongitude, charset), URLEncoder.encode(destLatitude, charset), URLEncoder.encode(destLongitude, charset),

                    URLEncoder.encode(transitmode, charset), URLEncoder.encode(trafficModel, charset),
                    URLEncoder.encode(key, charset));

            URLConnection urlConnection = new URL(url + "?" + query).openConnection();
            urlConnection.setRequestProperty("Accept-Charset", charset);
            InputStream response = urlConnection.getInputStream();

            return response;

        } catch (UnsupportedEncodingException e) {

        } catch (MalformedURLException m) {

        } catch (IOException io) {

        }

        return this.getResponse();
    }

    public String getOriginLongitude() {
        return originLongitude;
    }

    public void setOriginLongitude(String originLongitude) {
        this.originLongitude = originLongitude;
    }

    public String getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(String originLatitude) {
        this.originLatitude = originLatitude;
    }

    public String getDestLongitude() {
        return destLongitude;
    }

    public void setDestLongitude(String destLongitude) {
        this.destLongitude = destLongitude;
    }

    public String getDestLatitude() {
        return destLatitude;
    }

    public void setDestLatitude(String destLatitude) {
        this.destLatitude = destLatitude;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getTransitmode() {
        return transitmode;
    }

    public void setTransitmode(String transitmode) {
        this.transitmode = transitmode;
    }

    public String getTrafficModel() {
        return trafficModel;
    }

    public void setTrafficModel(String trafficModel) {
        this.trafficModel = trafficModel;
    }


    public String getUnits() {
        return units;
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }

    public String getCharset() {
        return charset;
    }


    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public void setResponse(InputStream response) {
        this.response = response;
    }

}

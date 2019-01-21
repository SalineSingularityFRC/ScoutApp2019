package com.example.nhwltrs.scoutapp2019;

/**
 * Created by nhwlt on 1/19/2019.
 */

import android.content.Context;

import org.json.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatabaseClass {

    public static BluetoothClass bluetooth;
    private static JSONObject tempRobotMatchData;
    public static JSONArray robotMatchData = new JSONArray();
    private static JSONArray tempTeamData = new JSONArray();
    private static JSONArray teamData = new JSONArray();

    public static void setup(BluetoothClass bluetooth) {
        DatabaseClass.bluetooth=bluetooth;
        try {
            FileInputStream fis = bluetooth.activity.openFileInput("teamData");
            teamData=new JSONArray(fis.read());
            fis.close();
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream fos = bluetooth.activity.openFileOutput("teamData", Context.MODE_PRIVATE);
                fos.write("".getBytes());
                fos.close();
                FileInputStream fis = bluetooth.activity.openFileInput("teamData");
                teamData=new JSONArray(fis.read());
                fis.close();
            } catch (IOException | JSONException e1) {
                e1.printStackTrace();
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeTeam(int teamNumber, String teamName){
        try {
            tempTeamData.put(new JSONObject("{"+
                    "\"team\":" + teamNumber + "," +
                    "\"name\":\"" + teamName + "\"" +
                    "}"));
            send();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static int getTeamNumber(int index){
        try {
            return teamData.getJSONObject(index).getInt("team");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String getTeamName(int index) {
        try {
            return teamData.getJSONObject(index).getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    public static int getTeamDatabaseLength(){
        return teamData.length();
    }

    public static int getLocalTeamNumber(int index) {
        try {
            return tempTeamData.getJSONObject(index).getInt("team");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String getLocalTeamName(int index) {
        try {
            return tempTeamData.getJSONObject(index).getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    public static int getLocalTeamDatabaseLength(){
        return tempTeamData.length();
    }

    public static void dataSent(String data){
        try {
            teamData=new JSONArray(data);
            FileOutputStream fos = bluetooth.activity.openFileOutput("teamData", bluetooth.activity.MODE_PRIVATE);
            fos.write(teamData.toString().getBytes());
            fos.close();
        }catch (JSONException | IOException e){
            e.printStackTrace();
            return;
        }
        robotMatchData= new JSONArray();
        tempTeamData= new JSONArray();

    }

    private static void send(){
        bluetooth.send("{\"matchData\":"+ robotMatchData.toString()+",\"teamData\":"+tempTeamData.toString()+"}");
    }

    public static void createRobotMatch(int teamNumber, String match, boolean onBlue) {
        try {
            tempRobotMatchData = new JSONObject("{" +
                    "\"team\":" + teamNumber + "," +
                    "\"matchID\":\"" + match + "\"," +
                    "\"onBlue\":"+onBlue+"," +
                    "\"startingPos\":-1," + //-1 is error, 1 is middle, 2 is close, 3 is far, - if level 2
                    "\"hatchesOnField\":-1," + //is the number of hatches on the field
                    "\"cargoOnField\":-1," + //is the number of cargo on the field
                    "\"sandstormSkill\":-1," + //-1 is error, 0 is nothing, 1 is moved, 2 is cargo ship hatch, 3 is level 1 hatch, 4 is level 2 hatch, 5 is level 3 hatch, 6 is cargo ship cargo, 7 is level 1, 8 is level 2 cargo, 9 is level 2 cargo
                    "\"cargoShipCargo\":[]," +
                    "\"cargoShipHatch\":[]," +
                    "\"rocketFirstLevelCargo\":[]," +
                    "\"rocketSecondLevelCargo\":[]," +
                    "\"rocketThirdLevelCargo\":[]," +
                    "\"rocketFirstLevelHatch\":[]," +
                    "\"rocketSecondLevelHatch\":[]," +
                    "\"rocketThirdLevelHatch\":[]," +
                    "\"climbingAbility\":-1," + //-1 is error, 0 is nothing, 1 is level 1, 2 is level 2, 3 is level 3
                    "}");
        } catch(JSONException e){
            e.printStackTrace();
        }
    }

    public static void setStartingPos(int pos){
        try{
            tempRobotMatchData.put("startingPos", pos);
        } catch(JSONException e){
            e.printStackTrace();
        }
    }

    public static void setPreLoadHatch(int hatches){
        try{
            tempRobotMatchData.put("hatchesOnField", hatches);
        } catch(JSONException e){
            e.printStackTrace();
        }
    }

    public static void setPreLoadCargo(int cargo){
        try{
            tempRobotMatchData.put("cargoOnField", cargo);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

    public static void setSandstormSkill(int skill){
        try{
            tempRobotMatchData.put("sandstormSkill", skill);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addCargoShipCargo(int ms){
        try{
            tempRobotMatchData.getJSONArray("cargoShipCargo").put(new JSONObject("{\"time\":" + ms + "}"));
        } catch(JSONException e){
            e.printStackTrace();
        }
    }

    public static void removeCargoShipCargo() {
        try {
            tempRobotMatchData.getJSONArray("cargoShipCargo").remove(tempRobotMatchData.getJSONArray("cargoShipCargo").length()-1);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addCargoShipHatch(int ms) {
        try {
            tempRobotMatchData.getJSONArray("cargoShipHatch").put(new JSONObject("{\"time\":" + ms + "}"));
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public static void removeCargoShipHatch() {
        try {
            tempRobotMatchData.getJSONArray("cargoShipHatch").remove(tempRobotMatchData.getJSONArray("cargoShipHatch").length()-1);
        } catch(JSONException e){
            e.printStackTrace();
        }
    }

    public static void addRocketFirstLevelCargo(int ms) {
        try {
            tempRobotMatchData.getJSONArray("rocketFirstLevelCargo").put(new JSONObject("{\"time\":" + ms + "}"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void removeRocketFirstLevelCargo() {
        try {
            tempRobotMatchData.getJSONArray("rocketFirstLevelCargo").remove(tempRobotMatchData.getJSONArray("rocketFirstLevelCargo").length()-1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addRocketFirstLevelHatch(int ms) {
        try {
            tempRobotMatchData.getJSONArray("rocketFirstLevelHatch").put(new JSONObject("{\"time\":" + ms + "}"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void removeRocketFirstLevelHatch() {
        try {
            tempRobotMatchData.getJSONArray("rocketFirstLevelHatch").remove(tempRobotMatchData.getJSONArray("rocketFirstLevelHatch").length()-1);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addRocketSecondLevelCargo(int ms) {
        try {
            tempRobotMatchData.getJSONArray("rocketSecondLevelCargo").put(new JSONObject("{\"time\":" + ms + "}"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void removeRocketSecondLevelCargo() {
        try {
            tempRobotMatchData.getJSONArray("rocketSecondLevelCargo").remove(tempRobotMatchData.getJSONArray("rocketSecondLevelCargo").length()-1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addRocketSecondLevelHatch(int ms) {
        try {
            tempRobotMatchData.getJSONArray("rocketSecondLevelHatch").put(new JSONObject("{\"time\":" + ms + "}"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void removeRocketSecondLevelHatch() {
        try {
            tempRobotMatchData.getJSONArray("rocketSecondLevelHatch").remove(tempRobotMatchData.getJSONArray("rocketSecondLevelHatch").length()-1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addRocketThirdLevelCargo(int ms) {
        try {
            tempRobotMatchData.getJSONArray("rocketThirdLevelCargo").put(new JSONObject("{\"time\":" + ms + "}"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void removeRocketThirdLevelCargo() {
        try {
            tempRobotMatchData.getJSONArray("rocketThirdLevelCargo").remove(tempRobotMatchData.getJSONArray("rocketThirdLevelCargo").length()-1);
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addRocketThirdLevelHatch(int ms) {
        try {
            tempRobotMatchData.getJSONArray("rocketThirdLevelHatch").put(new JSONObject("{\"time\":" + ms + "}"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void removeRocketThirdLevelHatch() {
        try {
            tempRobotMatchData.getJSONArray("rocketThirdLevelHatch").remove(tempRobotMatchData.getJSONArray("rocketThirdLevelHatch").length()-1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void setClimbSkill(int skill) {
        try {
            tempRobotMatchData.put("climbSkill", skill);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void finishMatch(){
        if(tempRobotMatchData==null){
            return;
        }
        robotMatchData.put(tempRobotMatchData);
        tempRobotMatchData=null;
        send();
    }
}

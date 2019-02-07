package ru.neginskiy.tm.aaa;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class MainClass {

    public static final String JSON_OBJ_FILE = "sample.json";
    public static final String JSON_MAP_FILE = "sampleMap.json";

    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.setStr(null);
        sample.setNum(123);
        sample.setDate(new Date());

        getJsonFromObject(sample);
        System.out.println(getObjectFromJson());

        List<Sample> sampleList = new ArrayList<>();
        sampleList.add(sample);
        sampleList.add(sample);

        SampleBox sampleBox = new SampleBox();
        sampleBox.setSampleList(sampleList);
        getJsonFromBox(sampleBox);
        for (Sample sampleInBoxsList : getBoxFromJson().getSampleList()){
            System.out.println(sampleInBoxsList);
        }
    }

    public static void getJsonFromObject(Sample sample) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(JSON_OBJ_FILE), sample);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Sample getObjectFromJson() {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            final Sample sample = mapper.readValue(new File(JSON_OBJ_FILE), Sample.class);
            return sample;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void getJsonFromBox(SampleBox sampleBox) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(JSON_MAP_FILE), sampleBox);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static SampleBox getBoxFromJson() {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(JSON_MAP_FILE), SampleBox.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
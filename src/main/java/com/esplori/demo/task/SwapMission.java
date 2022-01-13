package com.esplori.demo.task;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.esplori.demo.model.TaskCompleted;
import com.esplori.demo.model.TaskCompletedId;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;

public class SwapMission extends Mission {

    private static String URL = "https://api.thegraph.com/subgraphs/name/satoshi-kusumoto/pancakepractical";
    private static String QUERY_PATTERN = "{\"query\": \"{swaps(where:{from: \\\"%s\\\"}){id timestamp from to}}\", \"variables\": {}}";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String epochStart ;
    public SwapMission(){
        Date now = new Date();
        this.epochStart = String.valueOf(now.getTime() / 1000);
    }

    @Override
    public void run() {
        String query = String.format(QUERY_PATTERN, getAddress());
        RestTemplate restTemplate = getRestTemplate();
        try {
            boolean isDone = false;
            while (!isDone) {
                System.out.println("query  =" + query);
                ObjectMapper objectMapper = new ObjectMapper();
                Response response = restTemplate.postForObject(new URI(URL), query, Response.class);
                System.out.println(objectMapper.writeValueAsString(response));
                if(response != null && response.getData() != null ){
                    List<Swap> swaps = response.getData().getSwaps();
                    if(swaps != null && swaps.size() > 0){
                        for (Swap swap : swaps) {
                            if(swap.getTimestamp().compareTo(epochStart) > 0 ){
                                isDone = true;
                            }
                        }
                    }
                }

                System.out.println("wait 10 sec");
                Thread.sleep(10 * 1000);
                
            }
            getTaskCompletedRepository().save(new TaskCompleted(new TaskCompletedId("1", getAddress()), dateFormat.format(new Date())));
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private static class Response {
        private Data data;
        public Data getData(){
            return data;
        }
        public void setData(Data data){
            this.data = data;
        }
    }

    private static class Data {

        private List<Swap> swaps;

        public List<Swap> getSwaps() {
            return this.swaps;
        }

        public void setSwaps(List<Swap> swaps) {
            this.swaps = swaps;
        }
    }

    private static class Swap {
        private String from;
        private String id;
        private String to;
        private String timestamp;

        public Swap() {
        }

        public Swap(String from, String id, String to, String timestamp) {
            this.from = from;
            this.id = id;
            this.to = to;
            this.timestamp = timestamp;
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTo() {
            return this.to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

    }

}

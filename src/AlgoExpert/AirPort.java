package AlgoExpert;

import java.util.*;

public class AirPort {

    public static void main(String[] args) {
//        List<String> airports = Arrays.asList(
//                "CDG",
//                "DEL",
//                "DOH",
//                "DSM",
//                "EWR",
//                "EYW",
//                "HND",
//                "ICN",
//                "JFK",
//                "LGA",
//                "LHR",
//                "ORD",
//                "SAN",
//                "SFO",
//                "SIN",
//                "TLV",
//                "BGI",
//                "BUD");


        List<String> airports = Arrays.asList(
            //    "DSM",
                "BGI",
                "CDG",
                "DEL",
                "DOH",
                "DSM",
                "EWR",
                "EYW",
                "HND",
                "ICN",
                "JFK",
                "LGA",
                "LHR",
                "ORD",
                "SAN",
                "SFO",
                "SIN",
                "TLV",
                "BUD");

        List<List<String>> routes = new ArrayList<>();
        routes.add(Arrays.asList("DSM", "ORD"));
        routes.add(Arrays.asList("ORD", "BGI"));
        routes.add(Arrays.asList("BGI", "LGA"));
        routes.add(Arrays.asList("SIN", "CDG"));
        routes.add(Arrays.asList("CDG", "SIN"));
        routes.add(Arrays.asList("CDG", "BUD"));
        routes.add(Arrays.asList("DEL", "DOH"));
        routes.add(Arrays.asList("DEL", "CDG"));
        routes.add(Arrays.asList("TLV", "DEL"));
        routes.add(Arrays.asList("EWR", "HND"));
        routes.add(Arrays.asList("HND", "ICN"));
        routes.add(Arrays.asList("HND", "JFK"));
        routes.add(Arrays.asList("ICN", "JFK"));
        routes.add(Arrays.asList("JFK", "LGA"));
        routes.add(Arrays.asList("EYW", "LHR"));
        routes.add(Arrays.asList("LHR", "SFO"));
        routes.add(Arrays.asList("SFO", "SAN"));
        routes.add(Arrays.asList("SFO", "DSM"));
        routes.add(Arrays.asList("SAN", "EYW"));

//        routes.add(Arrays.asList("LGA", "DSM"));
//        routes.add(Arrays.asList("DSM", "LGA"));
//        routes.add(Arrays.asList("LGA", "EYW"));
//        routes.add(Arrays.asList("EYW", "JFK"));
//        routes.add(Arrays.asList("EYW", "EWR"));
//        routes.add(Arrays.asList("JFK", "ICN"));



        System.out.println(airportConnections(airports,routes,"LGA"));

    }

        public static int airportConnections(
                List<String> airports, List<List<String>> routes, String startingAirport) {

            //setting up start and end airpot
            Map<String,String> ports = new HashMap<>();
            //setting the graph
            Map<String,List<List<String>>> grp = new HashMap<>();

            //initializing the graph & start,end airports
            for(int i = 0;i<airports.size();i++) {
                ports.put(airports.get(i),airports.get(i));
                grp.put(airports.get(i), new ArrayList<>());
            }

            //creating the graph
            makeGraph(grp, routes);


            //traverse all the airports by using dfs
            Set<String> visited = new HashSet<>();

            dfs(startingAirport,startingAirport,grp,ports,visited);
            visited.add(startingAirport);
            for(String s : airports) {
                if (!visited.contains(s)) {
                    dfs(s,s,grp,ports,visited);
                }
            }


//            getParents( startingAirport, startingAirport, grp, new HashSet<>(),ports);
//
//            String parent1 = ports.get(startingAirport);
//            String parent2 = ports.get(parent1);
//
//            if (startingAirport.equalsIgnoreCase(parent2)) {
//                ports.put(startingAirport,startingAirport);
//            }
            // get parents from the traversed dfs
            Set<String> parents = getParents(ports, startingAirport);


            return parents.size()!=0 ? parents.size() : -1;
        }


        public static void makeGraph(Map<String,List<List<String>>> grp, List<List<String>> routes) {
            for(List<String> r : routes) {
                grp.get(r.get(0)).add(r);
            }
        }

        public static Set<String> getParents(Map<String,String> ports, String s) {
            Set<String> set = new HashSet<>();

            for(Map.Entry<String,String> entry : ports.entrySet()) {
                if(entry.getKey() == entry.getValue()  && !entry.getKey().equalsIgnoreCase(s)){
                    set.add(entry.getKey());
                }
            }

            return set;
        }


        public static void dfs(String str, String curr, Map<String,List<List<String>>> grp, Map<String,String> ports, Set<String> visited) {

            for(List<String> child : grp.get(curr)) {

                if(!visited.contains(child.get(1)) && !child.get(1).equalsIgnoreCase(str)) {
                    ports.put(child.get(1),str);
                    visited.add(child.get(1));
                    dfs(str,child.get(1),grp,ports,visited);
                }
            }
        }

        public static void getParents(String s,String curr, Map<String, List<List<String>>> grp, Set<String> visited,
                                      Map<String,String> ports ) {

            for(List<String> child : grp.get(curr)) {

                if(!visited.contains(child.get(1)) && !child.get(1).equalsIgnoreCase(s)) {
                    ports.put(child.get(1),s);
                        visited.add(child.get(1));
                        getParents(s,child.get(1), grp,visited,ports);
                }
            }
        }
    }




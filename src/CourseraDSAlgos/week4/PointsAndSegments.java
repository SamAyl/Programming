package CourseraDSAlgos.week4;

import java.util.*;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        List<Segment> segmentList = new ArrayList<>();
          //am creating new segments
        Segment[] originalSegment = new Segment[starts.length];
        for(int i = 0;i<starts.length;i++){
            originalSegment[i] = new Segment(starts[i],ends[i],i);
        }

        //sorting them accordingly
        Arrays.sort(originalSegment);

        //merging the segments.
        segmentList.add(new Segment(originalSegment[0].x,originalSegment[0].y));

        for(int i = 1;i<originalSegment.length;i++){
            int x = originalSegment[i].x;
            int y = originalSegment[i].y;

            Segment segment = segmentList.get(segmentList.size()-1);
            if(segment.x <=x && segment.y>=x && (segment.y<=y || segment.y>=y)){
                if(segment.y <= y){
                    segment.overlap.add(new Segment(x,segment.y));
                    segment.y = y;
                } else {
                    segment.overlap.add(new Segment(x,y));
                }
            }else {
                segmentList.add(new Segment(x,y));
            }

        }

        Points[] points1 = new Points[points.length];
        for(int i =0;i<points.length;i++){
            points1[i] = new Points(points[i],i);
        }

        for(Segment segment : segmentList) {
            if(!segment.overlap.isEmpty()){
                Collections.sort(segment.overlap);
            }
        }

        Arrays.sort(points1);
        int segmentIndex = 0;
        for(int i = 0;i<points1.length;i++){

            while (segmentIndex<segmentList.size()){
                if(points1[i].v>=segmentList.get(segmentIndex).x && points1[i].v<=segmentList.get(segmentIndex).y) {
                    if(segmentList.get(segmentIndex).overlap.isEmpty()) {
                        points1[i].count+=1;
                        break;
                    } else {
                        int count = points1[i].count;
                        count++;
                        for(Segment entry :segmentList.get(segmentIndex).overlap){
                            if(points1[i].v>=entry.x && points1[i].v<=entry.y){
                                count++;
                                }
                             else if(entry.x < points1[i].v) {

                            } else {
                                break;
                           }
                        }
                        points1[i].count = count;
                        break;
                    }

                } else if ( segmentList.get(segmentIndex).x > points1[i].v){
                     break;
                } else {
                    segmentIndex++;
                }
            }
        }

        int c = 0;
        for(int i = 0;i<points1.length;i++){

                cnt[points1[i].index] = points1[i].count;
                c++;
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n, m;
//        n = scanner.nextInt();
//        m = scanner.nextInt();
//        int[] starts = new int[n];
//        int[] ends = new int[n];
//        int[] points = new int[m];
//        for (int i = 0; i < n; i++) {
//            starts[i] = scanner.nextInt();
//            ends[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < m; i++) {
//            points[i] = scanner.nextInt();
//        }

    //    0 5 -3 2 7 10 10 10

        int[] starts = {1,1,1,9,11};
        int[] ends = {2,3,4,12,12};



        int[] points = {1,2,3,3,9,11,12};
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}


class Segment implements Comparable<Segment>{
   public int x;
   public int y;
   public int index;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return x == segment.x &&
                y == segment.y &&
                index == segment.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, index);
    }

    public Segment(int x, int y){
        this.x = x;
        this.y = y;

    }

    public Segment(int x,int y,int index){
        this.x = x;
        this.y = y;
        this.index = index;
    }

  public   List<Segment> overlap = new LinkedList<>();


    @Override
    public int compareTo(Segment o) {
        if(this.x <= o.x && this.y<=o.y ){
            return -1;
        } else if(this.x <=o.x && this.y > y){
            return 1;
        } else {
            return 0;
        }
    }
}


class Points implements Comparable<Points>{
   public int v;
   public int index;
   public int count = 0;

   public Points(int v,int index) {
       this.v = v;
       this.index = index;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return v == points.v &&
                index == points.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v, index);
    }

    @Override
    public int compareTo(Points o) {
        if(this.v>o.v){
            return 1;
        } else if( this.v < o.v){
            return -1;
        } else {
            if(this.index < o.index){
                return 1;
            } else if(this.index > o.index){
                return -1;
            } else {
                return 0;
            }
        }
    }
}


package com.example.hre.mines;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by H$R on 10/30/2017.
 */

public class Mine {
    private char[][] cell;

    public Mine() {
        cell = new char[5][5];
    }
    public void add(){
        ArrayList<Character> c = new ArrayList<>();
        for(int i = 0;i<7;i++)
            c.add('*');
        for(int i = 0;i<18;i++)
            c.add('!');
        Collections.shuffle(c);
        int l=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                cell[i][j]=c.get(l);
                l++;
            }
        }
    }

    public char get(int x,int y){
        return cell[x][y];
    }
    public ArrayList<Integer> counts(){
        ArrayList<Integer> counts = new ArrayList<>();
        int sum;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                sum=0;
                if(cell[i][j]!='*'){
                    int[] r1 = {i-1,i,i+1};
                    int[] c1 = {j-1,j,j+1};
                    for(int x = 0;x<3;x++){
                        if(r1[x]>=0&&r1[x]<=4){
                            for(int y=0;y<3;y++){
                                if(c1[y]>=0&&c1[y]<=4){
                                    if(cell[r1[x]][c1[y]]=='*')
                                        sum++;
                                }
                            }
                        }
                    }
                    counts.add(sum);
                }
                else
                    counts.add(10);
            }
        }
        return counts;
    }
}

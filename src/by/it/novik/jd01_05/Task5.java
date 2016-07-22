package by.it.novik.jd01_05;

import static java.lang.Math.*;
/**
 * Created by Kate Novik
 */
public class Task5 {

    /**
     * Вычисление функции (циклический вычислительный процесс с разветвлением).
     */
    public static void calculateCyclicallyFunction (){
        double r=0.491E4;
        double z;
    for (double p=-1.9;p<15.0;p+=1.5){
        if (p-1<0){
            z=3.8*sin(p);}
        else if ((p-1)>=0 && (p-1)<3){
            z=pow(p,3)-p;}
        else if (p-1>=3){
            z=pow((2/(p+1)+sin(PI/6)),5);
        }
        else continue;
        double y=pow(4.67,abs(z-1.4*r));
        System.out.format("При p=%-3.1f   y=%10E",p,y);
        System.out.println("");
    }
    }
}

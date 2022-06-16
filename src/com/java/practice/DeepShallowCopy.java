package com.java.practice;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/deep-shallow-lazy-copy-java-examples/
 */
public class DeepShallowCopy {

    public static void main(String[] args) {

        int[] arr = {10,15,20,25};

        int[] shallow = getShallow(arr);
        int[] deep = getDeep(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(shallow));
        System.out.println(Arrays.toString(deep));

        // If we change the initial arr[] then shallow will get effected but not the seep one

        arr[1] = 50;
        arr[2] = 100;
        System.out.println("******* After the modification **********");

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(shallow));
        System.out.println(Arrays.toString(deep));

    }

    private static int[] getDeep(int[] arr) {
        int[] deep = new int[arr.length];
        /*
        Here we are taking the value and creating the object, hence when arr[] get chnage it dones not have any impact
        in this object. Pass by value used here.
         */
        for(int i = 0; i< arr.length; i++){
            deep[i] = arr[i];
        }
        return deep;
    }

    private static int[] getShallow(int[] arr) {
        /*
        here we are referring object by reference , that mean both arr[] and shallow[] pointing to same
        memory location and change in anyone will affect the change in other too.
         */
        int[] shallow = arr;
        return shallow;
    }


}

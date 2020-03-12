package com.gezi.hdlw.util;

public class New {

	public static void main(String[] args) {
		int[] array=new int[]{1,2,9,5,3};
		int temp=0;
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;i++){
				if(array[j]>array[i]){
					temp=array[j];
					array[j]=array[i];
					array[i]=temp;
				}
			}
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}

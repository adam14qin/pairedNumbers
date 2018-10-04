package pairedNumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class pairedNumbers {
	private ArrayList<Integer> findPair(int n){
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		ArrayList<Integer> res=new ArrayList<Integer>();
		for (int i=1;i<=n;i++){
			int j=this.sumFactors(i);
			if(map.containsKey(j)){
				if(map.get(j)==i){
					res.add(i);
					res.add(j);
				}
			}else {
				map.put(i, j);
			}
		}
		return res;
	}
	
	private int sumFactors(int n){
		int sum=0;
		int i=1;
		while (i<=Math.sqrt(n)){
			if (n%i==0){
				sum+=i;
				if (i>=2){
					sum+=n/i;
				}
			}
			i++;
		}
		return sum;
	}
	
	public static void main(String[] args){
		int n=10000;
		pairedNumbers p=new pairedNumbers();
		//System.out.println(p.sumFactors(220));
		ArrayList<Integer> res=p.findPair(n);
		for (int k:res){
			System.out.println(k);
		}
		
	}
}
